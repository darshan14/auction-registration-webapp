package org.sports.cricket.service;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sports.cricket.dto.*;
import org.sports.cricket.model.*;
import org.sports.cricket.repository.AuctionPlayerRepository;
import org.sports.cricket.repository.AuctionPlayerStateRepository;
import org.sports.cricket.repository.PlayerRepository;
import org.sports.cricket.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*

What this method MUST do

Validate:
Auction is open
User has enough purse
Increase bid
Update DB
Record bid event
Return bid info to UI

 */
@Service
public class AuctionServiceImpl implements AuctionService {

    private static final Logger log = LoggerFactory.getLogger(AuctionServiceImpl.class);
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private AuctionPlayerRepository auctionPlayerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private AuctionPlayerStateRepository auctionPlayerstateRepository;

    @Autowired
    PythonBidService pythonBidService;

    @Autowired
    TeamService teamService;

    private final SimpMessagingTemplate messagingTemplate;

    private String INVALID_STATUS = "Invalid Bid";

    public AuctionServiceImpl(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    @Transactional
    public AuctionBidResponseDTO processUserBid(AuctionBidRequestDTO request) {

        String status = "IN PROGRESS";
        long nextBid, amRemainingPurseUserTeam;
        long playerId = request.getPlayerId();

        AuctionPlayerState newAuctionPlayerState = new AuctionPlayerState();;

        System.out.println("Processing User Bid...");

        Map<String, Object> auctionPlayerAttributes = getInitialAuctionPlayerState(playerId);

        Team userTeam = teamRepository.findByCdTeam(request.getCdUserTeam())
                .orElseThrow(() -> new RuntimeException("User team not found"));

        amRemainingPurseUserTeam = userTeam.getAmRemainingPurse().longValue();
        nextBid = (long) auctionPlayerAttributes.get("nextBid");

        if (amRemainingPurseUserTeam < nextBid) {
            status = INVALID_STATUS;
            System.out.println("Insufficient Purse");
            throw new RuntimeException("Insufficient Purse");
        }

        // Update auction state and save Bid History
        newAuctionPlayerState.setPlayerId(playerId);
        newAuctionPlayerState.setBidId((int) auctionPlayerAttributes.get("bidId") + 1);
        newAuctionPlayerState.setAmBaseRupees((long) auctionPlayerAttributes.get("amBase"));
        newAuctionPlayerState.setAmCurrentBid(nextBid);
        newAuctionPlayerState.setAmBidIncrement((long) auctionPlayerAttributes.get("amBidIncrement"));
        newAuctionPlayerState.setCdCurrentLeader(request.getCdUserTeam());
        newAuctionPlayerState.setBidStatus(status);
        auctionPlayerstateRepository.save(newAuctionPlayerState);

        // Update team purse
        userTeam.setAmRemainingPurse(BigDecimal.valueOf(userTeam.getAmRemainingPurse().longValue() - nextBid));
        userTeam.setAmUsedPurse(BigDecimal.valueOf(userTeam.getAmUsedPurse().longValue() + nextBid));
        teamRepository.save(userTeam);

        return new AuctionBidResponseDTO(playerId, request.getCdUserTeam(), nextBid, teamService.getAllTeamStates());
    }

    @Async
    @Transactional
    @Override
    public void processAiBidding(AuctionBidRequestDTO request) {

        long nextBid;
        long playerId = request.getPlayerId();
        String cdUserTeam = request.getCdUserTeam();
        String finalBidStatus;

        AuctionPlayerState newAuctionPlayerState;
        BidAIDecision decision;
        Team aiTeam;

        System.out.println("Call Auction Engine...");

        AuctionPlayer auctionPlayer = auctionPlayerRepository.findByPlayerId(playerId);

        Map<String, Object> auctionPlayerAttributes = getInitialAuctionPlayerState(playerId);
        nextBid = (long) auctionPlayerAttributes.get("nextBid");

        // Call to Python AI Model
        try {
            decision = pythonBidService.runBid(auctionPlayer, cdUserTeam, nextBid);
        } catch (Exception e) {
            decision = new BidAIDecision();
            decision.setResponseAIAction("STOP");
        }

        System.out.println("Decision: "+ decision.getCdTeam()+ " - "+ decision.getResponseAIAction());

        newAuctionPlayerState = new AuctionPlayerState();
        newAuctionPlayerState.setPlayerId(playerId);
        newAuctionPlayerState.setBidId((int) auctionPlayerAttributes.get("bidId") + 1);
        newAuctionPlayerState.setAmBaseRupees((long) auctionPlayerAttributes.get("amBase"));
        newAuctionPlayerState.setAmCurrentBid(nextBid);
        newAuctionPlayerState.setAmBidIncrement((long) auctionPlayerAttributes.get("amBidIncrement"));
        newAuctionPlayerState.setCdCurrentLeader(decision.getCdTeam());

        if (decision.getResponseAIAction().equals("STOP")) {
            // Inform UI that auction ended
            Optional<AuctionPlayerState> currentAuctionPlayerState = auctionPlayerstateRepository.findTopByPlayerIdOrderByIdDesc(playerId);
            if(currentAuctionPlayerState.isEmpty()) {
                finalBidStatus = "UNSOLD";
                newAuctionPlayerState.setBidStatus(finalBidStatus);
                auctionPlayerstateRepository.save(newAuctionPlayerState);
                playerRepository.updatePlayerAuctionStatus(playerId, "Unsold", BigDecimal.ZERO);
            } else {
                finalBidStatus = "SOLD";
                System.out.println(currentAuctionPlayerState.toString());
                auctionPlayerstateRepository.updateBidstatusById(currentAuctionPlayerState.get().getId(), finalBidStatus);
                playerRepository.updatePlayerAuctionStatus(playerId, "Sold", BigDecimal.valueOf(currentAuctionPlayerState.get().getAmCurrentBid()));
            }

            AuctionBidEventDTO auctionEventDTO = new AuctionBidEventDTO(
                    new AuctionBidResponseDTO(playerId,
                            currentAuctionPlayerState.get().getCdCurrentLeader(),
                            currentAuctionPlayerState.get().getAmCurrentBid(),
                            teamService.getAllTeamStates()),
                    finalBidStatus,
                    playerId + 1 <= playerRepository.findLastPlayerId() ? playerId+1 : null );

            System.out.println(auctionEventDTO.toString());

             // Push to UI
            messagingTemplate.convertAndSend(
                    "/topic/auction-event", auctionEventDTO);

        } else {

            newAuctionPlayerState.setBidStatus("IN PROGRESS");
            auctionPlayerstateRepository.save(newAuctionPlayerState);

            aiTeam = teamRepository.findByCdTeam(decision.getCdTeam())
                    .orElseThrow(() -> new RuntimeException("User team not found"));


            aiTeam.setAmRemainingPurse(BigDecimal.valueOf(aiTeam.getAmRemainingPurse().longValue() - nextBid));
            aiTeam.setAmUsedPurse(BigDecimal.valueOf(aiTeam.getAmUsedPurse().longValue() + nextBid));
            teamRepository.save(aiTeam);


            // Push to UI
            messagingTemplate.convertAndSend(
                    "/topic/auction",
                    new AuctionBidResponseDTO(playerId, aiTeam.getCdTeam(), nextBid, teamService.getAllTeamStates())
            );
        }

    }

    public Map<String, Object> getInitialAuctionPlayerState (long playerId) {
        int bidId;
        long amBase, amBidIncrement, amCurrentBid, nextBid;
        Map<String, Object> auctionPlayerAttributes = new HashMap<String, Object>();

        Player player = playerRepository.findByPlayerId(playerId);

        System.out.println("Player: "+player.toString());

        Optional<AuctionPlayerState> latestBidState = auctionPlayerstateRepository.findTopByPlayerIdOrderByIdDesc(playerId);

        if(latestBidState.isEmpty()) {
            bidId = 0;
            amCurrentBid = player.getAm_base_rupees().longValue();
            amBidIncrement = 0L;
            amBase = amCurrentBid;

        } else {
            AuctionPlayerState auctionPlayerState = latestBidState.get();
            bidId = auctionPlayerState.getBidId();
            amBase = auctionPlayerState.getAmBaseRupees();
            amCurrentBid = auctionPlayerState.getAmCurrentBid();
            amBidIncrement = getBidIncrement(amCurrentBid);
        }

        // Calculation for Total Bid Amount
        nextBid = amCurrentBid + amBidIncrement;

        auctionPlayerAttributes.put("bidId", bidId);
        auctionPlayerAttributes.put("amBase", amBase);
        auctionPlayerAttributes.put("amCurrentBid", amCurrentBid);
        auctionPlayerAttributes.put("amBidIncrement", amBidIncrement);
        auctionPlayerAttributes.put("nextBid", nextBid);

        return auctionPlayerAttributes;
    }

    public long getBidIncrement(long amCurrentBid) {

        long amIncrement;

        if(amCurrentBid == 7500000)
            amIncrement = 500000L;
        else if (amCurrentBid == 12500000)
            amIncrement = 1500000L;
        else if(amCurrentBid < 8000000)
            amIncrement = 1000000L;
        else if(amCurrentBid < 20000000)
            amIncrement = 2000000L;
        else if(amCurrentBid < 100000000)
            amIncrement = 5000000L;
        else amIncrement = 2500000L;

        return amIncrement;
    }

    // ===================== COUNTDOWN =====================
    private void startCountdown() {
        new Thread(() -> {
            try {
                for (int i = 5; i >= 0; i--) {
                    messagingTemplate.convertAndSend("/auction/topic/countdown", i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException ignored) {}
        }).start();
    }
}

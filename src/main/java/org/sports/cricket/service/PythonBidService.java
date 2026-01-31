package org.sports.cricket.service;

import org.sports.cricket.dto.BidAIRequest;
import org.sports.cricket.model.AuctionPlayer;
import org.sports.cricket.dto.BidAIDecision;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class PythonBidService {

    //private final RestTemplate restTemplate;
    private final String pythonUrl = "http://localhost:8000/ai/next-action";

    private String[] teams = {"CSK","MI","RCB","KKR","RR","SRH","DC","LSG","GT","PBKS"};

    /*public PythonBidService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate
                .setConnectTimeout(Duration.ofSeconds(2))
                .setReadTimeout(Duration.ofSeconds(5))
                .build();;
    }*/

    public BidAIDecision runBid(AuctionPlayer auctionPlayer, String cdUserTeam, Long nextBid) {

        String randomTeam = "NONE";
        BidAIDecision bidAIDecision = new BidAIDecision();
        BidAIRequest bidAIRequest = new BidAIRequest();

        System.out.println("Inside Python Bid Service...");

        bidAIRequest.setBidAmount(nextBid);
        bidAIRequest.setAuctionPlayer(auctionPlayer);

        List<String> aiTeams = Arrays.stream(teams)
                .filter(team -> !team.equals(cdUserTeam))
                .toList();

        if(Math.random() > 0.65) {
            randomTeam = aiTeams.get(ThreadLocalRandom.current().nextInt(aiTeams.size()));
            bidAIDecision.setCdTeam(randomTeam);
            bidAIDecision.setResponseAIAction("BID");
        } else {
            bidAIDecision.setCdTeam(randomTeam);
            bidAIDecision.setResponseAIAction("STOP");
        }

        return bidAIDecision;

        /*ResponseEntity<BidAIDecision> response =
                restTemplate.postForEntity(
                        pythonUrl,
                        bidAIRequest,
                        BidAIDecision.class
                );

        return response.getBody();*/

    }
}

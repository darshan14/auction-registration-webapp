package org.sports.cricket.controller;

import org.sports.cricket.dto.AuctionBidRequestDTO;
import org.sports.cricket.dto.AuctionBidResponseDTO;
import org.sports.cricket.model.Player;
import org.sports.cricket.model.Team;
import org.sports.cricket.service.AuctionPlayerStatusService;
import org.sports.cricket.service.AuctionService;
import org.sports.cricket.service.PlayerService;
import org.sports.cricket.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/auction")
public class AuctionController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private AuctionPlayerStatusService auctionPlayerStatusService;

    @GetMapping("/selectTeam")
    public String selectTeam(Model model) {
        model.addAttribute("teamList", teamService.getAllTeams());
        return "selectTeam";
    }


    @GetMapping("/auctionPlayer")
    public String auction(@RequestParam String userTeam, @RequestParam(required = false) Long playerId, Model model) {

        if(playerId == null)
            playerId = 0L;

        Player player = playerService.getNextPlayer(playerId);
        Team selectedTeam = teamService.getTeam(userTeam);
        List<Team> randomTeams = teamService.getRandomTeams(userTeam);
        int lastPlayerId = playerService.findLastPlayerId();

        model.addAttribute("player", player);
        model.addAttribute("userTeam", selectedTeam);
        model.addAttribute("leftTeams", randomTeams.subList(0, 5));
        model.addAttribute("rightTeams", randomTeams.subList(5, 9));
        model.addAttribute("lastPlayerId", lastPlayerId);
        return "auctionPlayer";
    }

    @Async
    @PostMapping(value = "/bid", produces = "application/json")
    @ResponseBody
    public AuctionBidResponseDTO bid(@RequestBody AuctionBidRequestDTO request) {

        System.out.println("In the Auction Controller..");

        // 1. User bid
        AuctionBidResponseDTO response = auctionService.processUserBid(request);

        // 2. Call Python AI
        auctionService.processAiBidding(request);
        // 3. Send response to UI

        System.out.println(request.getCdUserTeam() +" - "+request.getPlayerId() +" - "+ response.toString());

        return response;
    }

    /*@PostMapping("/bid")
    public String bid(@RequestParam int playerId, Model model) {
        String result = pythonBidService.runBid(playerId);
        model.addAttribute("bidResult", result);
        model.addAttribute("player", playerService.getNextPlayer());
        return "auctionPlayer";
    }*/
}
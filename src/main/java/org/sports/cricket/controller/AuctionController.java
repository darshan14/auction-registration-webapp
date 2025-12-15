package org.sports.cricket.controller;

import org.sports.cricket.model.Player;
import org.sports.cricket.model.Team;
import org.sports.cricket.service.PlayerService;
import org.sports.cricket.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/auction")
public class AuctionController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    @GetMapping("/selectTeam")
    public String selectTeam(Model model) {
        model.addAttribute("teamList", teamService.getAllTeams());
        return "selectTeam";
    }


    @PostMapping("/auctionPlayer")
    public String auction(@RequestParam String userTeam, Model model) {

        Player player = playerService.getNextPlayer();
        Team selectedTeam = teamService.getTeam(userTeam);
        List<Team> randomTeams = teamService.getRandomTeams(userTeam);

        model.addAttribute("player", player);
        model.addAttribute("userTeam", selectedTeam);
        model.addAttribute("leftTeams", randomTeams.subList(0, 5));
        model.addAttribute("rightTeams", randomTeams.subList(5, 9));
        return "auctionPlayer";
    }


    /*@PostMapping("/bid")
    public String bid(@RequestParam int playerId, Model model) {
        String result = pythonBidService.runBid(playerId);
        model.addAttribute("bidResult", result);
        model.addAttribute("player", playerService.getNextPlayer());
        return "auctionPlayer";
    }*/
}
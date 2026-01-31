package org.sports.cricket.controller;

import org.sports.cricket.model.Player;
import org.sports.cricket.model.PlayerForm;
import org.sports.cricket.service.FormInputOptionsService;
import org.sports.cricket.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private FormInputOptionsService formInputOptionsService;

    @GetMapping("/")
    public String viewHomePage(Model model) {

        return findPaginated(1, "category", "asc", "Initial", model);
    }

    @GetMapping("/showNewPlayerForm")
    public String showNewplayerForm(Model model) {
        // create model attribute to bind form data
        PlayerForm playerForm = new PlayerForm();
        model.addAttribute("playerForm", playerForm);
        model.addAttribute("countries", formInputOptionsService.getAllCountries());
        model.addAttribute("playingTypes", formInputOptionsService.getAllPlayingType());
        model.addAttribute("baseAmounts", formInputOptionsService.getAllBaseAmounts());
        return "new_player";
    }

    @PostMapping("/savePlayer")
    public String savePlayer(@ModelAttribute("player") PlayerForm playerForm) {
        // save player to database
        System.out.println(playerForm.getFirstName()+"\t"+playerForm.getLastName()+"\t"+playerForm.getDt_birth());
        playerService.savePlayer(playerForm);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable( value = "id") long id, Model model) {

        // get player from the service
        Player player = playerService.getPlayerById(id);

        // set player as a model attribute to pre-populate the form
        model.addAttribute("player", player);
        return "update_player";
    }

    @GetMapping("/deletePlayer/{id}")
    public String deleteplayer(@PathVariable (value = "id") long id) {

        // call delete player method
        this.playerService.deletePlayerById(id);
        return "redirect:/";
    }

    @GetMapping("/finalResult")
    public String displayFinalResult(Model model) {

        return findPaginated(1, "category", "asc", "final", model);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                @RequestParam("status") String status,
                                Model model) {
        int pageSize = 10;
        String filterCategory;

        Page<Player> page = playerService.findPaginated(pageNo, pageSize, sortField, sortDir);

        filterCategory = status.equalsIgnoreCase("final") ? "Sold" : "To Be Auctioned";

        //List<Player> listPlayers = page.getContent();         -- To Display only Auctioned players.
        List<Player> listPlayers = page.getContent()
                .stream()
                .filter(p -> filterCategory.equalsIgnoreCase(p.getStatus()))
                .toList();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listPlayers", listPlayers);
        return "index";
    }
}

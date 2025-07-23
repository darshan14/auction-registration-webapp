package org.sports.cricket.service;

import org.sports.cricket.model.PlayerCountry;
import org.sports.cricket.model.PlayerRole;
import org.sports.cricket.repository.PlayerCountryRepository;
import org.sports.cricket.repository.PlayerRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormInputOptionServiceImpl implements FormInputOptionsService {

    @Autowired
    private PlayerCountryRepository playerCountryRepository;

    @Autowired
    private PlayerRoleRepository playerRoleRepository;

    public List<PlayerCountry> getAllCountries() {
        //return List.of("Afghanistan", "Australia", "Bangladesh", "Canada", "England", "Germany", "France", "India", "Ireland", "Pakistan", "Nepal", "Netherlands", "New Zealand", "Scotland", "South Africa", "Sri Lanka", "West Indies", "United States", "Zimbabwe");
        return playerCountryRepository.findAll();
    }


    public List<PlayerRole> getAllPlayingType() {
        //return List.of("Batter", "Bowler", "All Rounder", "Wicket Keeper");
        return playerRoleRepository.findAll();
    }


    public List<String> getAllBaseAmounts() {
        return List.of("2 Crore", "1 Crore", "80 Lakhs", "50 Lakhs", "30 Lakhs");
    }
}

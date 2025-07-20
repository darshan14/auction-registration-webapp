package org.sports.cricket.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{

    public List<String> getAllCountries() {
        return List.of("Afghanistan", "Australia", "Bangladesh", "Canada", "England", "Germany", "France", "India", "Ireland", "Pakistan", "Nepal", "Netherlands", "New Zealand", "Scotland", "South Africa", "Sri Lanka", "West Indies", "United States", "Zimbabwe");
    }

}

package org.sports.cricket.controller;

import org.sports.cricket.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CSVLoader implements CommandLineRunner {

    @Autowired
    private CSVService csvService;

    @Override
    public void run(String... args) throws Exception {
        csvService.loadTeamCSV("src/main/resources/CTTEAM.csv");
        csvService.loadPlayerCSV("src/main/resources/tbplayerdisplay.csv");
    }
}

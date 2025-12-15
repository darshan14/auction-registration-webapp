package org.sports.cricket.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.sports.cricket.model.Player;
import org.sports.cricket.model.Team;
import org.sports.cricket.repository.PlayerRepository;
import org.sports.cricket.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    TeamRepository teamRepository;

    public void loadTeamCSV(String filePath) {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                .withSkipLines(1) // skip header
                .build();) {
            List<String[]> rows = reader.readAll();

            for (String[] row : rows) {
                // assuming CSV: id,name,email
                Team team = new Team();
                team.setCdTeamId(Integer.parseInt(row[0]));
                team.setCdTeam(row[1]);
                team.setDcTeam(row[2]);
                team.setAmTotalPurse(BigDecimal.valueOf(Double.parseDouble(row[3])));
                team.setAmUsedPurse(BigDecimal.valueOf(Double.parseDouble(row[4])));
                team.setAmRemainingPurse(BigDecimal.valueOf(Double.parseDouble(row[5])));
                team.setTotalIndianPlayers(Integer.parseInt(row[6]));
                team.setTotalOverseasPlayers(Integer.parseInt(row[7]));
                team.setTotalPlayers(Integer.parseInt(row[8]));
                team.setTeamLogoPath(row[9]);

                teamRepository.save(team);
            }

            System.out.println("CSV data loaded successfully!");
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    public void loadPlayerCSV(String filePath) {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                .withSkipLines(1) // skip header
                .build();) {
            List<String[]> rows = reader.readAll();

            for (String[] row : rows) {
                // assuming CSV: id,name,email
                Player player = new Player();
                player.setId(Long.parseLong(row[0]));
                player.setIdSet(row[1]);
                player.setFirstName(row[2]);
                player.setLastName(row[3]);
                player.setCountry(row[4]);
                player.setStateAssociation(row[5]);
                player.setAge(Integer.parseInt(row[6]));
                player.setPlaying_type(row[7]);
                player.setBattingStyle(row[8]);
                player.setBowlingStyle(row[9]);
                player.setIn_cap(Integer.parseInt(row[10]));
                player.setIn_overseas(Integer.parseInt(row[11]));
                player.setCd_team(row[12]);
                player.setAm_base_rupees(BigDecimal.valueOf(Double.parseDouble(row[13])));
                player.setAm_base_dollar(BigDecimal.valueOf(Double.parseDouble(row[14])));
                player.setCategory(row[15]);
                player.setStatus(row[16]);
                playerRepository.save(player);
            }

            System.out.println("CSV data loaded successfully!");
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

}

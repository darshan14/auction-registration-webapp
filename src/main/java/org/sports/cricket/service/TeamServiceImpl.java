package org.sports.cricket.service;

import org.sports.cricket.model.Team;
import org.sports.cricket.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team getTeam(String userTeam) {
        return teamRepository.findByCdTeam(userTeam)
                .orElseThrow(() ->
                        new RuntimeException("Team not found: " + userTeam));
    }

    public List<Team> getRandomTeams(String userTeam) {
        List<Team> remainingTeams = teamRepository.findByCdTeamNotAndCdTeamNot(userTeam, "NONE");

        Collections.shuffle(remainingTeams);

/*        if (remainingTeams.size() < to) {
            throw new RuntimeException("Not enough teams available");
        }

        return remainingTeams.subList(from, to);*/
        return remainingTeams;
    }

}

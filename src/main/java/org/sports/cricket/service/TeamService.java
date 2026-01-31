package org.sports.cricket.service;

import org.sports.cricket.dto.TeamStateDTO;
import org.sports.cricket.model.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    List<Team> getAllTeams();
    Team getTeam(String userTeam);
    List<Team> getRandomTeams(String userTeam);
    public List<TeamStateDTO> getAllTeamStates();
}

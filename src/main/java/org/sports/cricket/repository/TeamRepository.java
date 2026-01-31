package org.sports.cricket.repository;

import org.sports.cricket.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByCdTeam(String cdTeam);

    List<Team> findByCdTeamNotAndCdTeamNot(String userTeam, String noneTeam);
}

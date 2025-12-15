package org.sports.cricket.repository;

import org.sports.cricket.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p WHERE p.id > :lastId AND p.idSet <> 'RT' ORDER BY p.id ASC")
    Optional<Player> findNextPlayer(@Param("lastId") Long lastId);

    // Optional: get the first non-RT player
    Optional<Player> findFirstByIdSetNotOrderByIdAsc(String idSet);

}

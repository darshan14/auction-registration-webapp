package org.sports.cricket.repository;

import jakarta.transaction.Transactional;
import org.sports.cricket.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p WHERE p.id = :id AND p.idSet <> 'RT' ORDER BY p.id ASC")
    Optional<Player> findNextPlayer(@Param("id") Long id);

    @Query("SELECT p FROM Player p WHERE p.id = :playerId")
    Player findByPlayerId (@Param("playerId") Long playerId);

    // Optional: get the first non-RT player
    Optional<Player> findFirstByIdSetNotOrderByIdAsc(String idSet);

    @Query("SELECT MAX(p.id) FROM Player p WHERE p.idSet <> 'RT'")
    int findLastPlayerId();

    @Modifying
    @Transactional
    @Query("UPDATE Player p SET p.status = :status, p.am_final_rupees = :am_final_rupees WHERE p.id = :playerId")
    void updatePlayerAuctionStatus(@Param("playerId") Long playerId, @Param("status") String status, @Param("am_final_rupees") BigDecimal am_final_rupees);

}

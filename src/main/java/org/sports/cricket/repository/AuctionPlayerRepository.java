package org.sports.cricket.repository;

import org.sports.cricket.model.AuctionPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuctionPlayerRepository  extends JpaRepository<AuctionPlayer, Long> {

    @Query("SELECT p FROM AuctionPlayer p WHERE p.id = :playerId")
    AuctionPlayer findByPlayerId (@Param("playerId") Long playerId);

}

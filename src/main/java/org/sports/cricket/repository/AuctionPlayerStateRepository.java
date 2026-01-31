package org.sports.cricket.repository;

import jakarta.transaction.Transactional;
import org.sports.cricket.model.AuctionPlayerState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface AuctionPlayerStateRepository extends JpaRepository<AuctionPlayerState, Long>  {

    AuctionPlayerState findByPlayerId(Long playerId);

    Optional<AuctionPlayerState> findTopByPlayerIdOrderByIdDesc (Long playerId);

    @Modifying
    @Transactional
    @Query("UPDATE AuctionPlayerState a SET a.bidStatus= :bidStatus WHERE a.id = :id")
    void updateBidstatusById(@Param("id") Long id, @Param("bidStatus") String bidStatus);

}

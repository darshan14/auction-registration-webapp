package org.sports.cricket.repository;

import org.sports.cricket.model.PlayerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PlayerCategoryRepository extends JpaRepository <PlayerCategory, Integer> {

    @Query("SELECT p.dcCategory FROM PlayerCategory p WHERE p.cdPlayerRole = :cd_player_role AND p.inCap = :in_cap AND p.inOverseas = :in_overseas AND p.amBaseRupees = :am_base_rupees")
    //Optional <String> getPlayerCategory(@Param("cd_player_role") String cd_player_role, @Param("in_cap") int in_cap, @Param("in_overseas") int in_overseas, @Param("am_base_rupees") long am_base_rupees);
    String getPlayerCategory(@Param("cd_player_role") String cdPlayerRole, @Param("in_cap") int inCap, @Param("in_overseas") int inOverseas, @Param("am_base_rupees") long amBaseRupees);

}

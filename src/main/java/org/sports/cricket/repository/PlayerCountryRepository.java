package org.sports.cricket.repository;

import org.sports.cricket.model.PlayerCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerCountryRepository extends JpaRepository <PlayerCountry, Long> {
}

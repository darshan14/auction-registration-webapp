package org.sports.cricket.service;

import org.sports.cricket.model.PlayerCountry;
import org.sports.cricket.model.PlayerRole;

import java.util.List;

public interface FormInputOptionsService {

    public List<PlayerCountry> getAllCountries();

    public List<PlayerRole> getAllPlayingType();

    public List<String> getAllBaseAmounts();

}

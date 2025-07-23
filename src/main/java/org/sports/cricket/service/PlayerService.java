package org.sports.cricket.service;

import org.sports.cricket.model.Player;
import org.sports.cricket.model.PlayerForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PlayerService {

    List<Player> getAllPlayers();
    void savePlayer(PlayerForm playerForm);
    Player getPlayerById(long id);
    void deletePlayerById(long id);
    Page<Player> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}

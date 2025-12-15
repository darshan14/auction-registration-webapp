package org.sports.cricket.service;

import org.sports.cricket.model.Player;
import org.sports.cricket.model.PlayerForm;
import org.sports.cricket.repository.PlayerCategoryRepository;
import org.sports.cricket.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerCategoryRepository playerCategoryRepository;

    private Long lastPlayerId = 0L; // track last picked player

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public void savePlayer(PlayerForm playerForm) {

        Player player = new Player();

        //int dt_birth_int = Integer.parseInt(playerForm.getDt_birth().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        int age = Period.between(playerForm.getDt_birth(), LocalDate.now()).getYears();
        int in_cap = playerForm.getIsCapped().equals("capped") ? 1 : 0;
        int in_overseas = playerForm.getCountry().equals("IND") ? 0 : 1;
        double am_base_rupees =  getBaseAmount(playerForm.getBaseAmount());
        String stateAssoc = in_overseas == 1? "OVS" : "MCA";

        DecimalFormat df = new DecimalFormat("#.##");
        double am_base_dollar = Double.parseDouble(df.format(am_base_rupees/83.2));

        String cd_player_role = playerForm.getPlayingType();
        String dc_category = String.valueOf(playerCategoryRepository.getPlayerCategory(cd_player_role, in_cap, in_overseas, (long) Math.round(am_base_rupees)));
        String bowlingStyle = cd_player_role.equals("BWL") ? "RIGHT ARM FAST" : "";

        player.setIdSet("NW");
        player.setFirstName(playerForm.getFirstName());
        player.setLastName(playerForm.getLastName());
        player.setCountry(playerForm.getCountry());
        //player.setDt_birth(dt_birth_int);
        player.setAge(age);
        player.setPlaying_type(cd_player_role);
        player.setIn_cap(in_cap);
        player.setIn_overseas(in_overseas);
        player.setCd_team("NONE");
        player.setAm_base_rupees(BigDecimal.valueOf(am_base_rupees));
        player.setAm_base_dollar(BigDecimal.valueOf(am_base_dollar));
        player.setCategory(dc_category);
        player.setStatus("To Be Auctioned");
        player.setStateAssociation(stateAssoc);
        player.setBattingStyle("RHB");
        player.setBowlingStyle(bowlingStyle);
        this.playerRepository.save(player);
    }

    public double getBaseAmount(String base_amount) {
        double am_amount;
        switch(base_amount) {
            case "2 Crore":
                am_amount = 20000000;
                break;
            case "1 Crore":
                am_amount = 10000000;
                break;
            case "80 Lakhs":
                am_amount = 8000000;
                break;
            case "50 Lakhs":
                am_amount = 5000000;
                break;
            case "30 Lakhs":
                am_amount = 3000000;
                break;
            default:
                am_amount = 0;
        }

        return am_amount;
    }

    @Override
    public Player getPlayerById(long id) {
        Optional<Player> optional = playerRepository.findById(id);
        Player player = null;
        if (optional.isPresent()) {
            player = optional.get();
        } else {
            throw new RuntimeException(" Player not found for id :: " + id);
        }
        return player;
    }

    @Override
    public void deletePlayerById(long id) {
        this.playerRepository.deleteById(id);
    }

    @Override
    public Player getNextPlayer() {
        Optional<Player> nextPlayerOpt;

        if (lastPlayerId == 0) {
            // first call, pick first non-RT player (id >= 41)
            nextPlayerOpt = playerRepository.findFirstByIdSetNotOrderByIdAsc("RT");
        } else {
            // subsequent calls, pick next player after lastPlayerId
            nextPlayerOpt = playerRepository.findNextPlayer(lastPlayerId);
        }

        if (nextPlayerOpt.isPresent()) {
            Player next = nextPlayerOpt.get();
            lastPlayerId = next.getId(); // update last picked ID
            return next;
        }

        return null;
    }

    public Page<Player> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.playerRepository.findAll(pageable);
    }
}

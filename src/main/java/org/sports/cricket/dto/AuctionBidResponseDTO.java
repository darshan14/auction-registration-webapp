package org.sports.cricket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sports.cricket.model.Team;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuctionBidResponseDTO {

    private Long playerId;
    private String cdTeam;
    private Long amount;
    private List<TeamStateDTO> teamStates;

    @Override
    public String toString() {
        return "AuctionBidResponseDTO{" +
                "playerId=" + playerId +
                ", cdTeam='" + cdTeam + '\'' +
                ", amount=" + amount +
                ", teamStates=" + teamStates +
                '}';
    }
}

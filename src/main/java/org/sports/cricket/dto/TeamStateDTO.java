package org.sports.cricket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamStateDTO {
    private String teamCode;
    private BigDecimal amRemainingPurse;
    private BigDecimal amUsedPurse;
    private Integer totalPlayers;

    @Override
    public String toString() {
        return "TeamStateDTO{" +
                "teamCode='" + teamCode + '\'' +
                ", amRemainingPurse=" + amRemainingPurse +
                ", amUsedPurse=" + amUsedPurse +
                ", totalPlayers=" + totalPlayers +
                '}';
    }
}

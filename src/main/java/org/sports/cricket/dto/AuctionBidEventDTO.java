package org.sports.cricket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuctionBidEventDTO {

    private AuctionBidResponseDTO auctionBidResponseDTO;
    private String bidStatus;
    private Long nextPlayerId;

    @Override
    public String toString() {
        return "AuctionEventDTO{" +
                "auctionBidResponseDTO=" + auctionBidResponseDTO.toString() +
                ", bidStatus='" + bidStatus + '\'' +
                ", nextPlayerId=" + nextPlayerId +
                '}';
    }
}

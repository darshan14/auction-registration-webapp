package org.sports.cricket.dto;

import org.sports.cricket.model.AuctionPlayer;

public class BidAIRequest {

    private Long bidAmount;

    private AuctionPlayer auctionPlayer;

    public AuctionPlayer getAuctionPlayer() {
        return auctionPlayer;
    }

    public void setAuctionPlayer(AuctionPlayer auctionPlayer) {
        this.auctionPlayer = auctionPlayer;
    }

    public Long getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Long bidAmount) {
        this.bidAmount = bidAmount;
    }
}

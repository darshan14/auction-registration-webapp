package org.sports.cricket.dto;

public class AuctionBidRequestDTO {

    private int playerId;
    private String cdUserTeam;
    private int lastPlayerId;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getCdUserTeam() {
        return cdUserTeam;
    }

    public void setCdUserTeam(String cdUserTeam) {
        this.cdUserTeam = cdUserTeam;
    }

    public int getLastPlayerId() {
        return lastPlayerId;
    }

    public void setLastPlayerId(int lastPlayerId) {
        this.lastPlayerId = lastPlayerId;
    }
}

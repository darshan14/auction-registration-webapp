package org.sports.cricket.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbauctionplayerstate")
public class AuctionPlayerState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_player")
    private Long playerId;

    @Column(name = "id_bid")
    private Integer bidId;

    @Column(name = "am_base_rupees")
    private Long amBaseRupees;

    @Column(name = "am_current_bid")
    private Long amCurrentBid;

    @Column(name = "am_bid_increment")
    private Long amBidIncrement;

    @Column(name = "cd_current_Leader")
    private String cdCurrentLeader;

    @Column(name = "bid_status")
    private String bidStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public Integer getBidId() {
        return bidId;
    }

    public void setBidId(Integer bidId) {
        this.bidId = bidId;
    }

    public Long getAmBaseRupees() {
        return amBaseRupees;
    }

    public void setAmBaseRupees(Long amBaseRupees) {
        this.amBaseRupees = amBaseRupees;
    }

    public Long getAmCurrentBid() {
        return amCurrentBid;
    }

    public void setAmCurrentBid(Long amCurrentBid) {
        this.amCurrentBid = amCurrentBid;
    }

    public Long getAmBidIncrement() {
        return amBidIncrement;
    }

    public void setAmBidIncrement(Long amBidIncrement) {
        this.amBidIncrement = amBidIncrement;
    }

    public String getCdCurrentLeader() {
        return cdCurrentLeader;
    }

    public void setCdCurrentLeader(String cdCurrentLeader) {
        this.cdCurrentLeader = cdCurrentLeader;
    }

    public String getBidStatus() {
        return bidStatus;
    }

    public void setBidStatus(String bidStatus) {
        this.bidStatus = bidStatus;
    }

    @Override
    public String toString() {
        return "AuctionPlayerState{" +
                "id=" + id +
                ", playerId=" + playerId +
                ", bidId=" + bidId +
                ", amBaseRupees=" + amBaseRupees +
                ", amCurrentBid=" + amCurrentBid +
                ", amBidIncrement=" + amBidIncrement +
                ", cdCurrentLeader='" + cdCurrentLeader + '\'' +
                ", bidStatus='" + bidStatus + '\'' +
                '}';
    }
}

package org.sports.cricket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "ctteam")
public class Team {

    @Id
    @Column(name = "cd_team_id")
    private Integer cdTeamId;

    @Column(name = "cd_team")
    private String cdTeam;

    @Column(name = "dc_team")
    private String dcTeam;

    @Column(name = "am_total_purse")
    private BigDecimal amTotalPurse;

    @Column(name = "am_used_purse")
    private BigDecimal amUsedPurse;

    @Column(name = "am_remaining_purse")
    private BigDecimal amRemainingPurse;

    @Column(name = "total_indian_players")
    private Integer totalIndianPlayers;

    @Column(name = "total_overseas_players")
    private Integer totalOverseasPlayers;

    @Column(name = "total_players")
    private Integer totalPlayers;

    @Column(name = "team_logo_path")
    private String teamLogoPath;

    public Team() {}

    public Integer getCdTeamId() {
        return cdTeamId;
    }

    public void setCdTeamId(Integer cdTeamId) {
        this.cdTeamId = cdTeamId;
    }

    public String getCdTeam() {
        return cdTeam;
    }

    public void setCdTeam(String cdTeam) {
        this.cdTeam = cdTeam;
    }

    public String getDcTeam() {
        return dcTeam;
    }

    public void setDcTeam(String dcTeam) {
        this.dcTeam = dcTeam;
    }

    public BigDecimal getAmTotalPurse() {
        return amTotalPurse;
    }

    public void setAmTotalPurse(BigDecimal amTotalPurse) {
        this.amTotalPurse = amTotalPurse;
    }

    public BigDecimal getAmUsedPurse() {
        return amUsedPurse;
    }

    public void setAmUsedPurse(BigDecimal amUsedPurse) {
        this.amUsedPurse = amUsedPurse;
    }

    public BigDecimal getAmRemainingPurse() {
        return amRemainingPurse;
    }

    public void setAmRemainingPurse(BigDecimal amRemainingPurse) {
        this.amRemainingPurse = amRemainingPurse;
    }

    public Integer getTotalIndianPlayers() {
        return totalIndianPlayers;
    }

    public void setTotalIndianPlayers(Integer totalIndianPlayers) {
        this.totalIndianPlayers = totalIndianPlayers;
    }

    public Integer getTotalOverseasPlayers() {
        return totalOverseasPlayers;
    }

    public void setTotalOverseasPlayers(Integer totalOverseasPlayers) {
        this.totalOverseasPlayers = totalOverseasPlayers;
    }

    public Integer getTotalPlayers() {
        return totalPlayers;
    }

    public void setTotalPlayers(Integer totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    public String getTeamLogoPath() {
        return teamLogoPath;
    }

    public void setTeamLogoPath(String teamLogoPath) {
        this.teamLogoPath = teamLogoPath;
    }
}

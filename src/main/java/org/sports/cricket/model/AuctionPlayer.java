package org.sports.cricket.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbauctionplayer")
public class AuctionPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cd_set_id")
    private Integer cdSetId;

    @Column(name = "cd_state_assoc")
    private String cdStateAssoc;

    @Column(name = "pt_auction_set")
    private Integer ptAuctionSet;

    @Column(name = "pt_retain")
    private Integer ptRetain;

    @Column(name = "pt_country")
    private Integer ptCountry;

    @Column(name = "pt_age")
    private Integer ptAge;

    @Column(name = "cd_player_role")
    private String cdPlayerRole;

    @Column(name = "cd_player_role_id")
    private Integer cdPlayerRoleId;

    @Column(name = "pt_bat")
    private Integer ptBat;

    @Column(name = "pt_bwl")
    private Integer ptBwl;

    @Column(name = "pt_wk")
    private Integer ptWk;

    @Column(name = "pt_bat_style")
    private Integer ptBatStyle;

    @Column(name = "pt_cap")
    private Integer ptCap;

    @Column(name = "pt_indian")
    private Integer ptIndian;

    @Column(name = "pt_test_cap")
    private Integer ptTestCap;

    @Column(name = "cnt_test_caps")
    private Integer cntTestCaps;

    @Column(name = "pt_odi_cap")
    private Integer ptOdiCap;

    @Column(name = "cnt_odi_caps")
    private Integer cntOdiCaps;

    @Column(name = "pt_t20i_cap")
    private Integer ptT20iCap;

    @Column(name = "cnt_t20i_caps")
    private Integer cntT20iCaps;

    @Column(name = "cnt_ipl_caps")
    private Integer cntIplCaps;

    @Column(name = "pt_last_season")
    private Integer ptLastSeason;

    @Column(name = "am_base_rupees")
    private BigDecimal amBaseRupees;

    @Column(name = "am_base_dollar")
    private BigDecimal amBaseDollar;

    @Column(name = "pt_category")
    private String ptCategory;

    @Column(name = "cd_status_id")
    private Integer cdStatusId;

    @Column(name = "total_points")
    private Integer totalPoints;

    @Column(name = "rating", precision = 10, scale = 8)
    private BigDecimal rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCdSetId() {
        return cdSetId;
    }

    public void setCdSetId(Integer cdSetId) {
        this.cdSetId = cdSetId;
    }

    public String getCdStateAssoc() {
        return cdStateAssoc;
    }

    public void setCdStateAssoc(String cdStateAssoc) {
        this.cdStateAssoc = cdStateAssoc;
    }

    public Integer getPtAuctionSet() {
        return ptAuctionSet;
    }

    public void setPtAuctionSet(Integer ptAuctionSet) {
        this.ptAuctionSet = ptAuctionSet;
    }

    public Integer getPtRetain() {
        return ptRetain;
    }

    public void setPtRetain(Integer ptRetain) {
        this.ptRetain = ptRetain;
    }

    public Integer getPtCountry() {
        return ptCountry;
    }

    public void setPtCountry(Integer ptCountry) {
        this.ptCountry = ptCountry;
    }

    public Integer getPtAge() {
        return ptAge;
    }

    public void setPtAge(Integer ptAge) {
        this.ptAge = ptAge;
    }

    public String getCdPlayerRole() {
        return cdPlayerRole;
    }

    public void setCdPlayerRole(String cdPlayerRole) {
        this.cdPlayerRole = cdPlayerRole;
    }

    public Integer getCdPlayerRoleId() {
        return cdPlayerRoleId;
    }

    public void setCdPlayerRoleId(Integer cdPlayerRoleId) {
        this.cdPlayerRoleId = cdPlayerRoleId;
    }

    public Integer getPtBat() {
        return ptBat;
    }

    public void setPtBat(Integer ptBat) {
        this.ptBat = ptBat;
    }

    public Integer getPtBwl() {
        return ptBwl;
    }

    public void setPtBwl(Integer ptBwl) {
        this.ptBwl = ptBwl;
    }

    public Integer getPtWk() {
        return ptWk;
    }

    public void setPtWk(Integer ptWk) {
        this.ptWk = ptWk;
    }

    public Integer getPtBatStyle() {
        return ptBatStyle;
    }

    public void setPtBatStyle(Integer ptBatStyle) {
        this.ptBatStyle = ptBatStyle;
    }

    public Integer getPtCap() {
        return ptCap;
    }

    public void setPtCap(Integer ptCap) {
        this.ptCap = ptCap;
    }

    public Integer getPtIndian() {
        return ptIndian;
    }

    public void setPtIndian(Integer ptIndian) {
        this.ptIndian = ptIndian;
    }

    public Integer getPtTestCap() {
        return ptTestCap;
    }

    public void setPtTestCap(Integer ptTestCap) {
        this.ptTestCap = ptTestCap;
    }

    public Integer getCntTestCaps() {
        return cntTestCaps;
    }

    public void setCntTestCaps(Integer cntTestCaps) {
        this.cntTestCaps = cntTestCaps;
    }

    public Integer getPtOdiCap() {
        return ptOdiCap;
    }

    public void setPtOdiCap(Integer ptOdiCap) {
        this.ptOdiCap = ptOdiCap;
    }

    public Integer getCntOdiCaps() {
        return cntOdiCaps;
    }

    public void setCntOdiCaps(Integer cntOdiCaps) {
        this.cntOdiCaps = cntOdiCaps;
    }

    public Integer getPtT20iCap() {
        return ptT20iCap;
    }

    public void setPtT20iCap(Integer ptT20iCap) {
        this.ptT20iCap = ptT20iCap;
    }

    public Integer getCntT20iCaps() {
        return cntT20iCaps;
    }

    public void setCntT20iCaps(Integer cntT20iCaps) {
        this.cntT20iCaps = cntT20iCaps;
    }

    public Integer getCntIplCaps() {
        return cntIplCaps;
    }

    public void setCntIplCaps(Integer cntIplCaps) {
        this.cntIplCaps = cntIplCaps;
    }

    public Integer getPtLastSeason() {
        return ptLastSeason;
    }

    public void setPtLastSeason(Integer ptLastSeason) {
        this.ptLastSeason = ptLastSeason;
    }

    public BigDecimal getAmBaseRupees() {
        return amBaseRupees;
    }

    public void setAmBaseRupees(BigDecimal amBaseRupees) {
        this.amBaseRupees = amBaseRupees;
    }

    public BigDecimal getAmBaseDollar() {
        return amBaseDollar;
    }

    public void setAmBaseDollar(BigDecimal amBaseDollar) {
        this.amBaseDollar = amBaseDollar;
    }

    public String getPtCategory() {
        return ptCategory;
    }

    public void setPtCategory(String ptCategory) {
        this.ptCategory = ptCategory;
    }

    public Integer getCdStatusId() {
        return cdStatusId;
    }

    public void setCdStatusId(Integer cdStatusId) {
        this.cdStatusId = cdStatusId;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }
}

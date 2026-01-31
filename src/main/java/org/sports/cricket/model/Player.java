package org.sports.cricket.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbplayerdisplay")
public class Player {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_set")
    private String idSet;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "cd_country")
    private String country;

    @Column(name = "age")
    private Integer age;

    @Column(name = "cd_player_role")
    private String playing_type;

    @Column(name = "cd_state_assoc")
    private String stateAssociation;

    @Column(name = "cd_batting_style")
    private String battingStyle;

    @Column(name = "cd_bowling_style")
    private String bowlingStyle;

    @Column(name = "in_cap")
    private Integer in_cap;

    @Column(name = "in_overseas")
    private Integer in_overseas;

    @Column(name = "cd_team")
    private String cd_team;

    @Column(name = "am_base_rupees")
    private BigDecimal am_base_rupees;

    @Column(name = "am_base_dollar")
    private BigDecimal am_base_dollar;

    @Column(name = "am_final_rupees")
    private BigDecimal am_final_rupees;

    @Column(name = "dc_category")
    private String category;

    @Column(name = "dc_status")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdSet() {
        return idSet;
    }

    public void setIdSet(String idSet) {
        this.idSet = idSet;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPlaying_type() {
        return playing_type;
    }

    public void setPlaying_type(String playing_type) {
        this.playing_type = playing_type;
    }

    public String getStateAssociation() {
        return stateAssociation;
    }

    public void setStateAssociation(String stateAssociation) {
        this.stateAssociation = stateAssociation;
    }

    public String getBattingStyle() {
        return battingStyle;
    }

    public void setBattingStyle(String battingStyle) {
        this.battingStyle = battingStyle;
    }

    public String getBowlingStyle() {
        return bowlingStyle;
    }

    public void setBowlingStyle(String bowlingStyle) {
        this.bowlingStyle = bowlingStyle;
    }

    public Integer getIn_cap() {
        return in_cap;
    }

    public void setIn_cap(Integer in_cap) {
        this.in_cap = in_cap;
    }

    public Integer getIn_overseas() {
        return in_overseas;
    }

    public void setIn_overseas(Integer in_overseas) {
        this.in_overseas = in_overseas;
    }

    public String getCd_team() {
        return cd_team;
    }

    public void setCd_team(String cd_team) {
        this.cd_team = cd_team;
    }

    public BigDecimal getAm_base_rupees() {
        return am_base_rupees;
    }

    public void setAm_base_rupees(BigDecimal am_base_rupees) {
        this.am_base_rupees = am_base_rupees;
    }

    public BigDecimal getAm_base_dollar() {
        return am_base_dollar;
    }

    public void setAm_base_dollar(BigDecimal am_base_dollar) {
        this.am_base_dollar = am_base_dollar;
    }

    public BigDecimal getAm_final_rupees() {
        return am_final_rupees;
    }

    public void setAm_final_rupees(BigDecimal am_final_rupees) {
        this.am_final_rupees = am_final_rupees;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", idSet='" + idSet + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                ", playing_type='" + playing_type + '\'' +
                ", stateAssociation='" + stateAssociation + '\'' +
                ", battingStyle='" + battingStyle + '\'' +
                ", bowlingStyle='" + bowlingStyle + '\'' +
                ", in_cap=" + in_cap +
                ", in_overseas=" + in_overseas +
                ", cd_team='" + cd_team + '\'' +
                ", am_base_rupees=" + am_base_rupees +
                ", am_base_dollar=" + am_base_dollar +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

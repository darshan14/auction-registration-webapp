package org.sports.cricket.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbplayers")
public class Player {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_set")
    private String idSet;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "cd_country")
    private String country;

    @Column(name = "dt_birth")
    private int dt_birth;

    @Column(name = "age")
    private int age;

    @Column(name = "cd_player_role")
    private String playing_type;

    @Column(name = "in_cap")
    private int in_cap;

    @Column(name = "in_overseas")
    private int in_overseas;

    @Column(name = "cd_team")
    private String cd_team;

    @Column(name = "am_base_rupees")
    private double am_base_rupees;

    @Column(name = "am_base_dollar")
    private double am_base_dollar;

    @Column(name = "dc_category")
    private String category;

    @Column(name = "dc_status")
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getDt_birth() {
        return dt_birth;
    }

    public void setDt_birth(int dt_birth) {
        this.dt_birth = dt_birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlaying_type() {
        return playing_type;
    }

    public void setPlaying_type(String playing_type) {
        this.playing_type = playing_type;
    }

    public int getIn_cap() {
        return in_cap;
    }

    public void setIn_cap(int in_cap) {
        this.in_cap = in_cap;
    }

    public int getIn_overseas() {
        return in_overseas;
    }

    public void setIn_overseas(int in_overseas) {
        this.in_overseas = in_overseas;
    }

    public String getCd_team() {
        return cd_team;
    }

    public void setCd_team(String cd_team) {
        this.cd_team = cd_team;
    }

    public double getAm_base_rupees() {
        return am_base_rupees;
    }

    public void setAm_base_rupees(double am_base_rupees) {
        this.am_base_rupees = am_base_rupees;
    }

    public double getAm_base_dollar() {
        return am_base_dollar;
    }

    public void setAm_base_dollar(double am_base_dollar) {
        this.am_base_dollar = am_base_dollar;
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
}

package org.sports.cricket.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

//This class is created to get input from user fields.
public class PlayerForm {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dt_birth;

    private String firstName;

    private String lastName;

    private String country;

    private String playingType;

    private String isCapped;

    private String baseAmount;

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

    public LocalDate getDt_birth() {
        return dt_birth;
    }

    public void setDt_birth(LocalDate dt_birth) {
        this.dt_birth = dt_birth;
    }

    public String getPlayingType() {
        return playingType;
    }

    public void setPlayingType(String playingType) {
        this.playingType = playingType;
    }

    public String getIsCapped() {
        return isCapped;
    }

    public void setIsCapped(String isCapped) {
        this.isCapped = isCapped;
    }

    public String getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(String baseAmount) {
        this.baseAmount = baseAmount;
    }
}
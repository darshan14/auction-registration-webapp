package org.sports.cricket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ctcountry")
public class PlayerCountry {

    @Id
    @Column(name = "cd_country")
    private String cd_country;

    @Column(name = "dc_country")
    private String dc_country;

    public String getCd_country() {
        return cd_country;
    }

    public void setCd_country(String cd_country) {
        this.cd_country = cd_country;
    }

    public String getDc_country() {
        return dc_country;
    }

    public void setDc_country(String dc_country) {
        this.dc_country = dc_country;
    }
}

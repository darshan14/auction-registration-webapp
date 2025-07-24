package org.sports.cricket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ctplayerrole")
public class PlayerRole {

    @Id
    @Column(name = "cd_player_role_id")
    private String cd_player_role_id;

    @Column(name = "cd_player_role")
    private String cd_player_role;

    @Column(name = "dc_player_role")
    private String dc_player_role;

    public String getCd_player_role_id() {
        return cd_player_role_id;
    }

    public void setCd_player_role_id(String cd_player_role_id) {
        this.cd_player_role_id = cd_player_role_id;
    }

    public String getCd_player_role() {
        return cd_player_role;
    }

    public void setCd_player_role(String cd_player_role) {
        this.cd_player_role = cd_player_role;
    }

    public String getDc_player_role() {
        return dc_player_role;
    }

    public void setDc_player_role(String dc_player_role) {
        this.dc_player_role = dc_player_role;
    }
}

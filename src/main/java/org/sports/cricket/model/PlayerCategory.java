package org.sports.cricket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ctplayercategory")
public class PlayerCategory {

    @Id
    @Column(name = "cd_player_role_id")
    private int cdPlayerRoleId;

    @Column(name = "cd_player_role")
    private String cdPlayerRole;

    @Column(name = "in_cap")
    private int inCap;

    @Column(name = "in_overseas")
    private int inOverseas;

    @Column(name = "am_base_rupees")
    private long amBaseRupees;

    @Column(name = "dc_category")
    private String dcCategory;

    public int getCdPlayerRoleId() {
        return cdPlayerRoleId;
    }

    public void setCdPlayerRoleId(int cdPlayerRoleId) {
        this.cdPlayerRoleId = cdPlayerRoleId;
    }

    public String getCdPlayerRole() {
        return cdPlayerRole;
    }

    public void setCdPlayerRole(String cdPlayerRole) {
        this.cdPlayerRole = cdPlayerRole;
    }

    public int getInCap() {
        return inCap;
    }

    public void setInCap(int inCap) {
        this.inCap = inCap;
    }

    public int getInOverseas() {
        return inOverseas;
    }

    public void setInOverseas(int inOverseas) {
        this.inOverseas = inOverseas;
    }

    public long getAmBaseRupees() {
        return amBaseRupees;
    }

    public void setAmBaseRupees(long amBaseRupees) {
        this.amBaseRupees = amBaseRupees;
    }

    public String getDcCategory() {
        return dcCategory;
    }

    public void setDcCategory(String dcCategory) {
        this.dcCategory = dcCategory;
    }
}

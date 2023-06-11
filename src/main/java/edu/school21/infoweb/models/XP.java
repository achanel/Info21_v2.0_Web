package edu.school21.infoweb.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name = "XP")
@Table
public class XP {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private long xp_id;

    @JsonProperty("xpAmount")
    private Integer xpAmount;

    @ManyToOne
    @JoinColumn(name = "check_id")
    private Checks check;

    public XP(long xp_id, Integer xpAmount, Checks check) {
        this.xp_id = xp_id;
        this.xpAmount = xpAmount;
        this.check = check;
    }

    public XP() {
    }

    public long getXp_id() {
        return xp_id;
    }

    public void setXp_id(long xp_id) {
        this.xp_id = xp_id;
    }

    public Integer getXpAmount() {
        return xpAmount;
    }

    public void setXpAmount(Integer xpAmount) {
        this.xpAmount = xpAmount;
    }

    public Checks getCheck() {
        return check;
    }

    public void setCheck(Checks check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return "XP{" +
                "xp_id=" + xp_id +
                ", xpAmount=" + xpAmount +
                ", check=" + check +
                '}';
    }
}

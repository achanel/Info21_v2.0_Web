package edu.school21.infoweb.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "xp")
public class XP {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    @Column(name = "id")
    private long xp_id;

    @JsonProperty("xpamount")
    private Integer xpamount;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "`check`")
    private Checks check;

    public XP(long xp_id, Integer xpamount, Checks check) {
        this.xp_id = xp_id;
        this.xpamount = xpamount;
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

    public Integer getXpamount() {
        return xpamount;
    }

    public void setXpamount(Integer xpAmount) {
        this.xpamount = xpAmount;
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
                ", xpAmount=" + xpamount +
                ", check=" + check +
                '}';
    }
}

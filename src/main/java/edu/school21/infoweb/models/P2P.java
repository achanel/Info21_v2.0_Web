package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Time;
@Entity(name = "P2P")
@Table
public class P2P {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private long p2p_id;
    @ManyToOne
    @JoinColumn(name = "check_id")
    private Checks check;
    @ManyToOne
    @JoinColumn(name = "name")
    private Peers checkingPeer;

    @JsonProperty("checkState")
    private CheckState checkState;

    @JsonProperty("time")
    private Time time;

    public P2P(long p2p_id, Checks check, Peers checkingPeer, CheckState checkState, Time time) {
        this.p2p_id = p2p_id;
        this.check = check;
        this.checkingPeer = checkingPeer;
        this.checkState = checkState;
        this.time = time;
    }

    public P2P() {
    }

    public long getP2p_id() {
        return p2p_id;
    }

    public void setP2p_id(long p2p_id) {
        this.p2p_id = p2p_id;
    }

    public Checks getCheck() {
        return check;
    }

    public void setCheck(Checks check) {
        this.check = check;
    }

    public Peers getCheckingPeer() {
        return checkingPeer;
    }

    public void setCheckingPeer(Peers checkingPeer) {
        this.checkingPeer = checkingPeer;
    }

    public CheckState getCheckState() {
        return checkState;
    }

    public void setCheckState(CheckState checkState) {
        this.checkState = checkState;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "P2P{" +
                "id=" + p2p_id +
                ", check=" + check +
                ", checkingPeer=" + checkingPeer +
                ", checkState=" + checkState +
                ", time=" + time +
                '}';
    }
}

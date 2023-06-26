package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Time;
@Entity
@Table(name = "p2p")
public class P2P {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    @Column(name = "id")
    private long p2p_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "`Check`")
    private Checks check;
    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "checkingPeer")
    private Peers peer;

    @JsonProperty("state")
    private State state;

    @JsonProperty("time")
    private Time time;

    public P2P(long p2p_id, Checks check, Peers peer, State state, Time time) {
        this.p2p_id = p2p_id;
        this.check = check;
        this.peer = peer;
        this.state = state;
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

    public Peers getPeer() {
        return peer;
    }

    public void setPeer(Peers checkingPeer) {
        this.peer = checkingPeer;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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
                ", checkingPeer=" + peer +
                ", state=" + state +
                ", time=" + time +
                '}';
    }
}

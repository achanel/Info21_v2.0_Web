package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "P2P")
@Table
public class P2P {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private long id;
    @OneToMany
    @JsonProperty("check_id")
    private List<Checks> check = new LinkedList<>();
    @OneToMany
    @JoinColumn(name = "peers_id")
    private List<Peers> checkingPeer = new LinkedList<>();

    @JsonProperty("checkState")
    private CheckState checkState;

    @JsonProperty("time")
    private Time time;

    public P2P(long id, List<Checks> check, List<Peers> checkingPeer, CheckState checkState, Time time) {
        this.id = id;
        this.check = check;
        this.checkingPeer = checkingPeer;
        this.checkState = checkState;
        this.time = time;
    }

    public P2P() {
    }

    @Override
    public String toString() {
        return "P2P{" +
                "id=" + id +
                ", check=" + check +
                ", checkingPeer=" + checkingPeer +
                ", checkState=" + checkState +
                ", time=" + time +
                '}';
    }
}

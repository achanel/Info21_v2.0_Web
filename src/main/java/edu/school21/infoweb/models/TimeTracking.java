package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "TimeTracking")
@Table
public class TimeTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private long id;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "peer_id")
    private List<Peers> checkingPeer = new LinkedList<>();

    @JsonProperty("date")
    private Date date;
    @JsonProperty("time")
    private Time time;
    @JsonProperty("state")
    private short state;

    public TimeTracking(long id, List<Peers> checkingPeer, Date date, Time time, short state) {
        this.id = id;
        this.checkingPeer = checkingPeer;
        this.date = date;
        this.time = time;
        this.state = state;
    }

    public TimeTracking() {
    }

    @Override
    public String toString() {
        return "TimeTracking{" +
                "id=" + id +
                ", id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", state=" + state +
                '}';
    }
}

package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "timeTracking")
public class TimeTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private long id;
    @ManyToOne
    @JoinColumn(name = "peer")
    private Peers peer;

    @JsonProperty("`date`")
    private Date date;
    @JsonProperty("`time`")
    private Time time;
    @JsonProperty("state")
    private State state;

    public TimeTracking(long id, Peers peer, Date date, Time time, State state) {
        this.id = id;
        this.peer = peer;
        this.date = date;
        this.time = time;
        this.state = state;
    }

    public TimeTracking() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Peers getPeer() {
        return peer;
    }

    public void setPeer(Peers peer) {
        this.peer = peer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TimeTracking{" +
                "id=" + id +
                ", peer=" + peer +
                ", date=" + date +
                ", time=" + time +
                ", state=" + state +
                '}';
    }
}

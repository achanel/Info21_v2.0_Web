package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import java.util.Date;

@Entity(name = "Checks")
@Table
public class Checks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private long check_id;

    @JsonProperty("date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "name")
    private Peers peer;

    @ManyToOne
    @JoinColumn(name = "title")
    private Tasks task;

    public Checks(long check_id, Date date, Peers peer, Tasks task) {
        this.check_id = check_id;
        this.date = date;
        this.peer = peer;
        this.task = task;
    }

    public Checks(long check_id, Date date, Peers peer) {
        this.check_id = check_id;
        this.date = date;
        this.peer = peer;
    }

    public Checks() {
    }

    public long getCheck_id() {
        return check_id;
    }

    public void setCheck_id(long checks_id) {
        this.check_id = checks_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Peers getPeer() {
        return peer;
    }

    public void setPeer(Peers peer) {
        this.peer = peer;
    }

    public Tasks getTask() {
        return task;
    }

    public void setTask(Tasks task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Checks{" +
                "checks_id=" + check_id +
                ", date=" + date +
                ", peer=" + peer +
                ", task=" + task +
                '}';
    }
}

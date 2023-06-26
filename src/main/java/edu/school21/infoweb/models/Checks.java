package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "`Checks`")
public class Checks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    @Column(name = "id")
    private long checks_id;
    @JsonProperty("date")
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "peer")
    private Peers peer;

    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "task")
    private Tasks task;

    public Checks(long checks_id, Date date, Peers peer, Tasks task) {
        this.checks_id = checks_id;
        this.date = date;
        this.peer = peer;
        this.task = task;
    }

    public Checks(long checks_id, Date date, Peers peer) {
        this.checks_id = checks_id;
        this.date = date;
        this.peer = peer;
    }

    public Checks() {
    }

    public long getChecks_id() {
        return checks_id;
    }

    public void setChecks_id(long checks_id) {
        this.checks_id = checks_id;
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
                "checks_id=" + checks_id +
                ", date=" + date +
                ", peer=" + peer +
                ", task=" + task +
                '}';
    }
}

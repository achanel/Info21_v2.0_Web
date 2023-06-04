package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity(name = "Checks")
@Table
public class Checks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private long id;

    @JsonProperty("peer")
    private String peer;

    @JsonProperty("task")
    private String task;

    @JsonProperty("date")
    private Date date;

    @OneToMany
    @JoinColumn(name = "peer_id")
    private List<Peers> peersList;

    @OneToMany
    @JoinColumn(name = "task_id")
    private List<Tasks> tasksList;

    public Checks(long id, String peer, String task, Date date) {
        this.id = id;
        this.peer = peer;
        this.task = task;
        this.date = date;
    }

    public Checks(){
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPeer() {
        return peer;
    }

    public void setPeer(String peer) {
        this.peer = peer;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Checks{" +
                "id=" + id +
                ", peer=" + peer +
                ", task=" + task +
                ", date=" + date +
                '}';
    }
}

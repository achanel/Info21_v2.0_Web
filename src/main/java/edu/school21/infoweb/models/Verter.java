package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Time;

@Entity(name = "Verter")
@Table
public class Verter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private long verter_id;
    @ManyToOne
    @JoinColumn(name = "check_id")
    private Checks check;
    @JsonProperty("checkState")
    private CheckState checkState;
    @JsonProperty("time")
    private Time time;

    public Verter(long verter_id, Checks check, CheckState checkState, Time time) {
        this.verter_id = verter_id;
        this.check = check;
        this.checkState = checkState;
        this.time = time;
    }

    public Verter() {
    }

    public long getVerter_id() {
        return verter_id;
    }

    public void setVerter_id(long id) {
        this.verter_id = id;
    }

    public Checks getCheck() {
        return check;
    }

    public void setCheck(Checks check) {
        this.check = check;
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
        return "Verter{" +
                "id=" + verter_id +
                ", check=" + check +
                ", checkState=" + checkState +
                ", time=" + time +
                '}';
    }
}

package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "verter")
public class Verter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    @Column(name = "id")
    private long verter_id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "`Check`")
    private Checks check;
    @JsonProperty("state")
    @Enumerated(EnumType.STRING)
    @Type(type = "edu.school21.infoweb.utils.EnumTypePostgreSql")
    private CheckStatus state;
    @JsonProperty("time")
    private Time time;

    public Verter(long verter_id, Checks check, CheckStatus state, Time time) {
        this.verter_id = verter_id;
        this.check = check;
        this.state = state;
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

    public CheckStatus getState() {
        return state;
    }

    public void setState(CheckStatus checkStatus) {
        this.state = checkStatus;
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
                ", checkStatus=" + state +
                ", time=" + time +
                '}';
    }
}

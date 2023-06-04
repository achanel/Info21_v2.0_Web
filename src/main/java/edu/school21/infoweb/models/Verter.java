package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "Verter")
@Table
public class Verter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private Integer id;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "check_id")
    private List<Checks> check = new LinkedList<>();
    @JsonProperty("checkState")
    private CheckState checkState;
    @JsonProperty("time")
    private Time time;

    public Verter(Integer id, List<Checks> check, CheckState checkState, Time time) {
        this.id = id;
        this.check = check;
        this.checkState = checkState;
        this.time = time;
    }

    public Verter() {
    }

    @Override
    public String toString() {
        return "Verter{" +
                "id=" + id +
                ", check=" + check +
                ", checkState=" + checkState +
                ", time=" + time +
                '}';
    }
}

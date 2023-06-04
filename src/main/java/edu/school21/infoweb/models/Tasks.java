package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name = "Tasks")
@Table
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private long id;

    @JsonProperty("tittle")
    private String tittle;
    @JsonProperty("parentTask")
    private String parentTask;
    @JsonProperty("maxXP")
    private Integer maxXP;

    public Tasks(long id, String tittle, String parentTask, Integer maxXP) {
        this.id = id;
        this.tittle = tittle;
        this.parentTask = parentTask;
        this.maxXP = maxXP;
    }

    public Tasks() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", parentTask='" + parentTask + '\'' +
                ", maxXP=" + maxXP +
                '}';
    }
}

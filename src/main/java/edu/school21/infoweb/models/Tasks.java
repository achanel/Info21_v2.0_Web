package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "Tasks")
public class Tasks {

    @Id
    @Column
    @JsonProperty("tittle")
    private String tittle;
    @Column
    @JsonProperty("parentTask")
    private String parentTask;
    @Column
    @JsonProperty("maxXP")
    private Integer maxXP;

    public Tasks(String tittle, String parentTask, Integer maxXP) {
        this.tittle = tittle;
        this.parentTask = parentTask;
        this.maxXP = maxXP;
    }

    public Tasks() {
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getParentTask() {
        return parentTask;
    }

    public void setParentTask(String parentTask) {
        this.parentTask = parentTask;
    }

    public Integer getMaxXP() {
        return maxXP;
    }

    public void setMaxXP(Integer maxXP) {
        this.maxXP = maxXP;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                ", tittle='" + tittle + '\'' +
                ", parentTask='" + parentTask + '\'' +
                ", maxXP=" + maxXP +
                '}';
    }
}

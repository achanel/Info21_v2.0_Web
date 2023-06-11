package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name = "Tasks")
@Table
public class Tasks {

    @Id
    @JsonProperty("tittle")
    private String tittle;
    @JsonProperty("parentTask")
    private String parentTask;
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

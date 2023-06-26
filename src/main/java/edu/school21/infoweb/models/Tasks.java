package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Tasks {

    @Id
    @JsonProperty("title")
    private String title;
    @JsonProperty("parentTask")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Column(name = "parenttask")
    private String parentTask;
    @JsonProperty("maxXP")
    private Integer maxXP;

    public Tasks(String title, String parentTask, Integer maxXP) {
        this.title = title;
        this.parentTask = parentTask;
        this.maxXP = maxXP;
    }

    public Tasks() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String tittle) {
        this.title = tittle;
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
                ", tittle='" + title + '\'' +
                ", parentTask='" + parentTask + '\'' +
                ", maxXP=" + maxXP +
                '}';
    }
}

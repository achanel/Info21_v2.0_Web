package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Peers")
@Table
public class Peers {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("birthday")
    private LocalDateTime birthday;

    public Peers(long id, String name, LocalDateTime birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public Peers(String name, LocalDateTime birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Peers() {
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public LocalDateTime getBirthday() {
        return this.birthday;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String toString() {
        return "Peers(id=" + this.getId() + ", name=" + this.getName() + ", birthday=" + this.getBirthday() + ")";
    }
}

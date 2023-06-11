package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Peers")
@Table
public class Peers {

    @Id
    @JsonProperty("name")
    private String name;
    @JsonProperty("birthday")
    private Date birthday;

    public Peers(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Peers() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}

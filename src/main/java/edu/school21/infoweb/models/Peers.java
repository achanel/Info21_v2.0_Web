package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Peers")
public class Peers {

    @Id @Column
    @JsonProperty("name")
    private String name;
    @JsonProperty("birthday")
    @Column
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

    @Override
    public String toString() {
        return "Peers{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

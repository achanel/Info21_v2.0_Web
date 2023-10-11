package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "peers")
public class Peers {

    @Id
    @JsonProperty("name")
    private String nickname;
    @JsonProperty("birthday")
    private Date birthday;

    public Peers(String name, Date birthday) {
        this.nickname = name;
        this.birthday = birthday;
    }

    public Peers() {
    }

    public String getName() {
        return nickname;
    }

    public void setName(String name) {
        this.nickname = name;
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
                "name='" + nickname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

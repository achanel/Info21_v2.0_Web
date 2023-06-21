package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Peers")
public class Peers {

    @Id
    @JsonProperty("name")
    private String name;
    @JsonProperty("birthday")
    private Date birthday;
//
//    @OneToMany(mappedBy = "peer")
//    private List<Checks> checks;

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

//    public List<Checks> getChecks() {
//        return checks;
//    }
//
//    public void setChecks(List<Checks> checks) {
//        this.checks = checks;
//    }

    @Override
    public String toString() {
        return "Peers{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

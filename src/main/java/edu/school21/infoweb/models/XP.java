package edu.school21.infoweb.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "XP")
@Table
public class XP {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private long id;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "check_id")
    private List<Checks> check = new LinkedList<>();
    @JsonProperty("xpAmount")
    private Integer xpAmount;

    public XP(long id, List<Checks> check, Integer xpAmount) {
        this.id = id;
        this.check = check;
        this.xpAmount = xpAmount;
    }

    public XP() {
    }

    @Override
    public String toString() {
        return "XP{" +
                "id=" + id +
                ", check=" + check +
                ", xpAmount=" + xpAmount +
                '}';
    }
}

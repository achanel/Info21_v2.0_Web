package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Friends")
@Table
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private Integer id;

    @JsonProperty("peer1")
    private String peer1;

    @JsonProperty("peer2")
    private String peer2;
    @OneToMany
    @JoinColumn(name = "peer_id")
    private List<Peers> peer1List;
    @OneToMany
    @JoinColumn(name = "peer_id")
    private List<Peers> peer2List;

    public Friends(Integer id, String peer1, String peer2) {
        this.id = id;
        this.peer1 = peer1;
        this.peer2 = peer2;
    }

    public Friends() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Friends{" +
                "id=" + id +
                ", peer1=" + peer1 +
                ", peer2=" + peer2 +
                '}';
    }
}

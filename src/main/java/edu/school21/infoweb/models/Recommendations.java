package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "Recommendations")
@Table
public class Recommendations {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private Integer id;
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "peer_id")
    private List<Peers> peer = new LinkedList<>();
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "peer_id")
    private List<Peers> recomendatedPeer = new LinkedList<>();

    public Recommendations(Integer id, List<Peers> peer, List<Peers> recomendatedPeer) {
        this.id = id;
        this.peer = peer;
        this.recomendatedPeer = recomendatedPeer;
    }

    public Recommendations() {
    }

    @Override
    public String toString() {
        return "Recommendations{" +
                "id=" + id +
                ", peer=" + peer +
                ", recomendatedPeer=" + recomendatedPeer +
                '}';
    }
}

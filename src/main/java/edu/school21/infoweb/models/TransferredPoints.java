package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "TransferredPoints")
@Table
public class TransferredPoints {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private long id;
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "peer_id")
    private List<Peers> checkingPeer = new LinkedList<>();
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "peer_id")
    private List<Peers> checkedPeer = new LinkedList<>();
    @JsonProperty("pointsAmount")
    private Integer pointsAmount;

    public TransferredPoints(long id, List<Peers> checkingPeer, List<Peers> checkedPeer, Integer pointsAmount) {
        this.id = id;
        this.checkingPeer = checkingPeer;
        this.checkedPeer = checkedPeer;
        this.pointsAmount = pointsAmount;
    }

    public TransferredPoints() {
    }

    @Override
    public String toString() {
        return "TransferredPoints{" +
                "id=" + id +
                ", checkingPeer=" + checkingPeer +
                ", checkedPeer=" + checkedPeer +
                ", pointsAmount=" + pointsAmount +
                '}';
    }
}


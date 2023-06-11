package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name = "TransferredPoints")
@Table
public class TransferredPoints {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private long transferredPoints_id;
    @ManyToOne
    @JoinColumn(name = "name1")
    private Peers checkingPeer;
    @ManyToOne
    @JoinColumn(name = "name2")
    private Peers checkedPeer;
    @JsonProperty("pointsAmount")
    private Integer pointsAmount;

    public TransferredPoints(long transferredPoints_id, Peers checkingPeer, Peers checkedPeer, Integer pointsAmount) {
        this.transferredPoints_id = transferredPoints_id;
        this.checkingPeer = checkingPeer;
        this.checkedPeer = checkedPeer;
        this.pointsAmount = pointsAmount;
    }

    public TransferredPoints() {
    }

    public long getTransferredPoints_id() {
        return transferredPoints_id;
    }

    public void setTransferredPoints_id(long transferedPoints_id) {
        this.transferredPoints_id = transferedPoints_id;
    }

    public Peers getCheckingPeer() {
        return checkingPeer;
    }

    public void setCheckingPeer(Peers checkingPeer) {
        this.checkingPeer = checkingPeer;
    }

    public Peers getCheckedPeer() {
        return checkedPeer;
    }

    public void setCheckedPeer(Peers checkedPeer) {
        this.checkedPeer = checkedPeer;
    }

    public Integer getPointsAmount() {
        return pointsAmount;
    }

    public void setPointsAmount(Integer pointsAmount) {
        this.pointsAmount = pointsAmount;
    }

    @Override
    public String toString() {
        return "TransferredPoints{" +
                "id=" + transferredPoints_id +
                ", checkingPeer=" + checkingPeer +
                ", checkedPeer=" + checkedPeer +
                ", pointsAmount=" + pointsAmount +
                '}';
    }
}


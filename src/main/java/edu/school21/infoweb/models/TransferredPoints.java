package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "transferredPoints")
public class TransferredPoints {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    @Column(name = "id")
    private long transferredPoints_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "checkingPeer")
    private Peers checkingPeer;
    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "checkedPeer")
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


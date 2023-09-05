package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "transferredpoints")
public class TransferredPoints {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    @Column(name = "id")
    private long transferredPoints_id;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "checkingpeer")
    private Peers checkingpeer;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "checkedpeer")
    private Peers checkedpeer;
    @JsonProperty("pointsamount")
    private Integer pointsamount;

    public TransferredPoints(long transferredPoints_id, Peers checkingpeer, Peers checkedpeer, Integer pointsamount) {
        this.transferredPoints_id = transferredPoints_id;
        this.checkingpeer = checkingpeer;
        this.checkedpeer = checkedpeer;
        this.pointsamount = pointsamount;
    }

    public TransferredPoints() {
    }

    public long getTransferredPoints_id() {
        return transferredPoints_id;
    }

    public void setTransferredPoints_id(long transferedPoints_id) {
        this.transferredPoints_id = transferedPoints_id;
    }

    public Peers getCheckingpeer() {
        return checkingpeer;
    }

    public void setCheckingpeer(Peers checkingPeer) {
        this.checkingpeer = checkingPeer;
    }

    public Peers getCheckedpeer() {
        return checkedpeer;
    }

    public void setCheckedpeer(Peers checkedPeer) {
        this.checkedpeer = checkedPeer;
    }

    public Integer getPointsamount() {
        return pointsamount;
    }

    public void setPointsamount(Integer pointsAmount) {
        this.pointsamount = pointsAmount;
    }

    @Override
    public String toString() {
        return "TransferredPoints{" +
                "id=" + transferredPoints_id +
                ", checkingPeer=" + checkingpeer +
                ", checkedPeer=" + checkedpeer +
                ", pointsAmount=" + pointsamount +
                '}';
    }
}


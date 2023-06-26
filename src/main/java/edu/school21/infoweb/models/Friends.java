package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "friends")
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    @Column(name = "id")
    private long friend_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "peer1")
    private Peers peer1;
    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "peer2")
    private Peers peer2;

    public Friends(long friend_id, Peers peer1, Peers peer2) {
        this.friend_id = friend_id;
        this.peer1 = peer1;
        this.peer2 = peer2;
    }

    public Friends() {
    }

    public long getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(long friend_id) {
        this.friend_id = friend_id;
    }

    public Peers getPeer1() {
        return peer1;
    }

    public void setPeer1(Peers peer1) {
        this.peer1 = peer1;
    }

    public Peers getPeer2() {
        return peer2;
    }

    public void setPeer2(Peers peer2) {
        this.peer2 = peer2;
    }

    @Override
    public String toString() {
        return "Friends{" +
                "id=" + friend_id +
                ", peer1=" + peer1 +
                ", peer2=" + peer2 +
                '}';
    }
}

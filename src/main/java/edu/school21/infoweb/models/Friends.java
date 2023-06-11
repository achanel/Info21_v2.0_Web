package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "Friends")
@Table
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private long friend_id;

    @ManyToOne
    @JoinColumn(name = "name1")
    private Peers peer1;
    @ManyToOne
    @JoinColumn(name = "name2")
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

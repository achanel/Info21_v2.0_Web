package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity(name = "Recommendations")
@Table
public class Recommendations {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    private long recommendations_id;
    @ManyToOne
    @JoinColumn(name = "name1")
    private Peers peer;
    @ManyToOne
    @JoinColumn(name = "name2")
    private Peers recommendatedPeer;

    public Recommendations(long recommendations_id, Peers peer, Peers recommendatedPeer) {
        this.recommendations_id = recommendations_id;
        this.peer = peer;
        this.recommendatedPeer = recommendatedPeer;
    }

    public Recommendations() {
    }

    public long getRecommendations_id() {
        return recommendations_id;
    }

    public void setRecommendations_id(long recommendations_id) {
        this.recommendations_id = recommendations_id;
    }

    public Peers getPeer() {
        return peer;
    }

    public void setPeer(Peers peer) {
        this.peer = peer;
    }

    public Peers getRecommendatedPeer() {
        return recommendatedPeer;
    }

    public void setRecommendatedPeer(Peers recommendatedPeer) {
        this.recommendatedPeer = recommendatedPeer;
    }

    @Override
    public String toString() {
        return "Recommendations{" +
                "id=" + recommendations_id +
                ", peer=" + peer +
                ", recomendatedPeer=" + recommendatedPeer +
                '}';
    }
}

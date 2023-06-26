package edu.school21.infoweb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "recommendations")
public class Recommendations {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonIgnoreProperties
    @Column(name = "id")
    private long recommendations_id;
    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "peer")
    private Peers peer;
    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "recommendedPeer")
    private Peers recommendedPeer;

    public Recommendations(long recommendations_id, Peers peer, Peers recommendedPeer) {
        this.recommendations_id = recommendations_id;
        this.peer = peer;
        this.recommendedPeer = recommendedPeer;
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

    public Peers getRecommendedPeer() {
        return recommendedPeer;
    }

    public void setRecommendedPeer(Peers recommendatedPeer) {
        this.recommendedPeer = recommendatedPeer;
    }

    @Override
    public String toString() {
        return "Recommendations{" +
                "id=" + recommendations_id +
                ", peer=" + peer +
                ", recomendatedPeer=" + recommendedPeer +
                '}';
    }
}

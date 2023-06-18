package edu.school21.infoweb.services;

import edu.school21.infoweb.models.Recommendations;

import java.util.List;

public interface RecommendationsService {
    List<Recommendations> getAllRecommendations();

    List<Recommendations> saveRecommendations(List<Recommendations> recommendations);

    void deleteRecommendations(List<Recommendations> recommendations);
}

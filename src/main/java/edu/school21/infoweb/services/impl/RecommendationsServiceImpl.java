package edu.school21.infoweb.services.impl;

import edu.school21.infoweb.models.Recommendations;
import edu.school21.infoweb.repositories.RecommendationsRepository;
import edu.school21.infoweb.services.RecommendationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecommendationsServiceImpl implements RecommendationsService {
    @Autowired
    private RecommendationsRepository recommendationsRepository;

    @Override
    @Transactional
    public List<Recommendations> getAllRecommendations() {
        System.out.println("recommendationsServise: " + recommendationsRepository.findAll());
        return recommendationsRepository.findAll();
    }

    @Override
    @Transactional
    public List<Recommendations> saveRecommendations(List<Recommendations> recommendations) {
        return (List<Recommendations>) recommendationsRepository.saveAll(recommendations);
    }

    @Override
    public void deleteRecommendations(List<Recommendations> recommendations) {
        recommendationsRepository.deleteAll(recommendations);
    }
}

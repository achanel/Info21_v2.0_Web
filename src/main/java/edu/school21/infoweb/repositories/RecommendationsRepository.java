package edu.school21.infoweb.repositories;

import edu.school21.infoweb.models.Recommendations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationsRepository extends CrudRepository<Recommendations, Long> {
    List<Recommendations> findAll();
}

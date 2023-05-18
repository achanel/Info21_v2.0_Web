package edu.school21.infoweb.repository;

import edu.school21.infoweb.models.P2P;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface P2PRepository extends CrudRepository<P2P, Integer> {
}

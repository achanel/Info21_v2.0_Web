package edu.school21.infoweb.repositories;

import edu.school21.infoweb.models.P2P;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface P2PRepository extends CrudRepository<P2P, Integer> {
}

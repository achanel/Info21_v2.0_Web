package edu.school21.infoweb.repositories;

import edu.school21.infoweb.models.Checks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecksRepository extends CrudRepository<Checks, Integer> {
}

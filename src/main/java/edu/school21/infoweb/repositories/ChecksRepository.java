package edu.school21.infoweb.repositories;

import edu.school21.infoweb.models.Checks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChecksRepository extends CrudRepository<Checks, Long> {
    List<Checks> findAll();
}

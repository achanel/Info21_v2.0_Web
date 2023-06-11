package edu.school21.infoweb.repositories;

import edu.school21.infoweb.models.Verter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VerterRepository extends CrudRepository<Verter, Long> {
    List<Verter> findAll();
}

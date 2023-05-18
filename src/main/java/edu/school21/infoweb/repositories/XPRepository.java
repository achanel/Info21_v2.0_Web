package edu.school21.infoweb.repositories;

import edu.school21.infoweb.models.XP;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XPRepository extends CrudRepository<XP, Integer> {
}

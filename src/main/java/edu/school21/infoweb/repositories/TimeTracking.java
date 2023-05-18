package edu.school21.infoweb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTracking extends CrudRepository<TimeTracking, Integer> {
}

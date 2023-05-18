package edu.school21.infoweb.repositories;

import edu.school21.infoweb.models.TimeTracking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTrackingRepository extends CrudRepository<TimeTracking, Integer> {
}

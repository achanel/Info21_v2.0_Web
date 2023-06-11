package edu.school21.infoweb.repositories;

import edu.school21.infoweb.models.TimeTracking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeTrackingRepository extends CrudRepository<TimeTracking, Long> {
    List<TimeTracking> findAll();
}

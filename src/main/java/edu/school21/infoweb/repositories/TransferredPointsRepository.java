package edu.school21.infoweb.repositories;

import edu.school21.infoweb.models.TransferredPoints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferredPointsRepository extends CrudRepository<TransferredPoints, Integer> {
}

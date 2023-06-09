package edu.school21.infoweb.repositories;

import edu.school21.infoweb.models.TransferredPoints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferredPointsRepository extends CrudRepository<TransferredPoints, Long> {

    List<TransferredPoints> findAll();
}

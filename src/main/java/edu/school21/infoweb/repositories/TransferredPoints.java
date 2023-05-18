package edu.school21.infoweb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferredPoints extends CrudRepository<edu.school21.infoweb.models.TransferredPoints, Integer> {
}

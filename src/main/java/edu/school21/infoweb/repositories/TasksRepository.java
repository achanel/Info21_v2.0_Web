package edu.school21.infoweb.repositories;

import edu.school21.infoweb.models.Tasks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends CrudRepository<Tasks, String> {
    List<Tasks> findAll();
}

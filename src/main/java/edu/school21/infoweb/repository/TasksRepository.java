package edu.school21.infoweb.repository;

import edu.school21.infoweb.models.Tasks;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Tasks, String> {
}

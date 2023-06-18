package edu.school21.infoweb.services;

import edu.school21.infoweb.models.Tasks;

import java.util.List;

public interface TasksService {
    List<Tasks> getAllTasks();

    List<Tasks> saveTasks(List<Tasks> tasks);

    void deleteTasks(List<Tasks> tasks);
}

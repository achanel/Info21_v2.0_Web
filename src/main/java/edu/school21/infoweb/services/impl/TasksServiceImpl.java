package edu.school21.infoweb.services.impl;

import edu.school21.infoweb.models.Tasks;
import edu.school21.infoweb.repositories.TasksRepository;
import edu.school21.infoweb.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TasksServiceImpl implements TasksService {
    @Autowired
    private TasksRepository tasksRepository;

    @Override
    @Transactional
    public List<Tasks> getAllTasks() {
        System.out.println("tasksService: " + tasksRepository.findAll());
        return tasksRepository.findAll();
    }

    @Override
    @Transactional
    public List<Tasks> saveTasks(List<Tasks> tasks) {
        return tasks == null ? null : (List<Tasks>) tasksRepository.saveAll(tasks);
    }

    @Override
    public void deleteTasks(List<Tasks> tasks) {
        if (tasks != null) {
            tasksRepository.deleteAll(tasks);
        }
    }
}

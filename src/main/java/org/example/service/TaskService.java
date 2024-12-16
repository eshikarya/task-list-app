package org.example.service;

import org.example.entity.Task;

import java.util.List;

public interface TaskService {
    Task createTasks(Task task);
    List<Task> fetchTasks();

    Task editTasks(Task task);

    String deleteTasks(int id);

    List<Task> searchTasks(String query);

}

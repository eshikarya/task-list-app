package org.example.service;

import org.example.entity.ContactPerson;
import org.example.entity.Task;
import org.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTasks(Task task){
        return taskRepository.save(task);
    }

    @Override
    public List<Task> fetchTasks(){
        return taskRepository.findAll();
    }

    @Override
    public List<Task> searchTasks(String query){
        List<Task> tasks = taskRepository.searchTasks(query);
        return tasks;
    }

    @Override
    public Task editTasks(Task task){
        ContactPerson contactPerson = new ContactPerson();

        Task updateTask = taskRepository.findById(task.getId()).orElse(null);
        if (updateTask!=null){
            if (task.getTaskType()!=null)updateTask.setTaskType(task.getTaskType());
           if (task.getDate()!=null)updateTask.setDate(task.getDate());
           if (task.getEntityName()!=null)updateTask.setEntityName(task.getEntityName());
           if (task.getNotes()!=null)updateTask.setNotes(task.getNotes());
           if (task.getStatus()!=null)updateTask.setStatus(task.getStatus());
           if (task.getTime()!=null)updateTask.setTime(task.getTime());

            taskRepository.save(updateTask);
            return updateTask;
        }
        return null;
    }

    @Override
    public String deleteTasks(int id){
        taskRepository.deleteById(id);
        return "Deleted "+ id;
    }
}

package org.example.controller;

import org.example.entity.ContactPerson;
import org.example.entity.Task;
import org.example.service.ContactPersonService;
import org.example.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasksapp")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    ContactPersonService contactPersonService;

    @PostMapping("/addContact")
    public ContactPerson addContactPerson(@RequestBody ContactPerson contactPerson){
        return contactPersonService.addContactPerson(contactPerson);
    }

    @GetMapping("/fetchContacts")
    public List<ContactPerson> getContacts(){
        return contactPersonService.fetchContactPersons();
    }

    @DeleteMapping("/deleteContacts/{id}")
    public String deleteContacts(@PathVariable int id){
        return contactPersonService.deleteContactPersons(id);
    }

    //    Assign Task
    @PutMapping("/{contact_person_id}/tasks/{task_id}")
    public ContactPerson assignTaskToUser(@PathVariable int contact_person_id, @PathVariable int task_id){
        return contactPersonService.assignTaskToUser(contact_person_id,task_id);
    }

    //Create Task
    @PostMapping("/createTask")
    public Task setTasks(@RequestBody Task task){
        return taskService.createTasks(task);
    }

    // Get Tasks
    @GetMapping("/fetchAllTasks")
    public List<Task> getTasks(){
        return taskService.fetchTasks();
    }

//     Filter Tasks
    @GetMapping("/searchTask")
    public ResponseEntity<List<Task>> filterTasks(@RequestParam("query") String query){
        return ResponseEntity.ok(taskService.searchTasks(query));
    }

    //Edit existing task
    @PutMapping("/editTask")
    public Task editTasks(@RequestBody Task task){
        return taskService.editTasks(task);
    }


    //Delete existing task
    @DeleteMapping("/deleteTask/{id}")
    public String deleteTasks(@PathVariable int id){
        return taskService.deleteTasks(id);
    }
}

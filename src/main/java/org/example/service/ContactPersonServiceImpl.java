package org.example.service;

import org.example.entity.ContactPerson;
import org.example.entity.Task;
import org.example.repository.ContactPersonRepository;
import org.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ContactPersonServiceImpl implements ContactPersonService {

    @Autowired
    private ContactPersonRepository contactPersonRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public ContactPerson addContactPerson(ContactPerson contactPerson){
        return contactPersonRepository.save(contactPerson);

    }

    @Override
    public List<ContactPerson> fetchContactPersons(){
        return contactPersonRepository.findAll();
    }

    @Override
    public String deleteContactPersons(int id){
        contactPersonRepository.deleteById(id);
        return "Deleted "+ id;
    }

    @Override
    public ContactPerson assignTaskToUser(int contact_person_id, int task_id){
        ContactPerson contactPerson = contactPersonRepository.findById(contact_person_id).get();
        Task task = taskRepository.findById(task_id).get();

        Set<Task> taskSet = null;
        taskSet = contactPerson.getAssignedTasks();
        taskSet.add(task);
        contactPerson.setAssignedTasks(taskSet);
        return contactPersonRepository.save(contactPerson);
    }
}

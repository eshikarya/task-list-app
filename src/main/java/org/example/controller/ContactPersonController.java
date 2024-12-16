//package org.example.controller;
//
//import org.example.entity.ContactPerson;
//import org.example.service.ContactPersonService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/contacts")
//public class ContactPersonController {
//    @Autowired
//    ContactPersonService contactPersonService;
//
//    @PostMapping("/addContact")
//    public ContactPerson addContactPerson(@RequestBody ContactPerson contactPerson){
//        return contactPersonService.addContactPerson(contactPerson);
//    }
//
//    @GetMapping("/fetchContacts")
//    public List<ContactPerson> getContacts(){
//        return contactPersonService.fetchContactPersons();
//    }
//
//    @DeleteMapping("/deleteContacts/{id}")
//    public String deleteContacts(@PathVariable int id){
//        return contactPersonService.deleteContactPersons(id);
//    }
//
//    //    Assign Task
//    @PutMapping("/{contact_person_id}/tasks/{task_id}")
//    public ContactPerson assignTaskToUser(@PathVariable int contact_person_id, @PathVariable int task_id){
//        return contactPersonService.assignTaskToUser(contact_person_id,task_id);
//    }
//
//
//}

package org.example.service;

import org.example.entity.ContactPerson;

import java.util.List;

public interface ContactPersonService {

    ContactPerson addContactPerson(ContactPerson contactPerson);
    List<ContactPerson> fetchContactPersons();
    String deleteContactPersons(int id);

    ContactPerson assignTaskToUser(int contact_person_id, int task_id);

}

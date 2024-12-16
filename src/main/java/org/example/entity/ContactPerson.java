package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CONTACT_PERSON")
@NoArgsConstructor
@AllArgsConstructor
public class ContactPerson {

    @Id
    @Column
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactPersonId;

    @Column
    private String contactPerson;

    @ManyToMany
    @JoinTable(name = "contact_task",
    joinColumns = @JoinColumn(name = "contact_person"),
    inverseJoinColumns =@JoinColumn(name = "task_id"))
    private Set<Task> assignedTasks = new HashSet<>();

    public Set<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(Set<Task> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }

    public int getContactPersonId() {
        return contactPersonId;
    }

    public void setContactPersonId(int contactPersonId) {
        this.contactPersonId = contactPersonId;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
}

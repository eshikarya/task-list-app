package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TASK")
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDate date;

    @Column
    private String entityName;

    @Column
    private LocalTime time;

    private String taskType;

    @Column
    private String notes;

    @Column
    private String status = "Open";

    @ManyToMany(mappedBy = "assignedTasks")
    @JsonIgnore
    private Set<ContactPerson> contactPersonSet = new HashSet<>();


    public Set<ContactPerson> getContactPersonSet() {
        return contactPersonSet;
    }

    public void setContactPersonSet(Set<ContactPerson> contactPersonSet) {
        this.contactPersonSet = contactPersonSet;
    }


    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

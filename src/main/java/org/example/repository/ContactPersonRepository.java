package org.example.repository;

import org.example.entity.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactPersonRepository extends JpaRepository<ContactPerson,Integer> {
// datatype of primary key declared with JPA Repo
// JPA REPOSITORY helps us do CRUD operations to our DB Entities
// Every entity will have a repository file
}

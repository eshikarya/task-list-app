package org.example.repository;

import org.example.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Integer> {

    @Query(value = "SELECT * from task t WHERE "+
    "t.entity_name LIKE CONCAT('%',:query,'%')"+
    "OR t.date LIKE CONCAT('%',:query,'%')"+
    "OR t.task_type LIKE CONCAT('%',:query,'%')"+
    "OR t.status LIKE CONCAT('%',:query,'%')",nativeQuery = true)
    List<Task> searchTasks(String query);

}

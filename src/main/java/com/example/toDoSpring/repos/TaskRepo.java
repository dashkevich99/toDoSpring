package com.example.toDoSpring.repos;

import org.springframework.data.repository.CrudRepository;
import com.example.toDoSpring.domain.Task;

import java.util.List;

public interface TaskRepo extends CrudRepository<Task, Integer> {
    List<Task> findByTag(String tag);
}
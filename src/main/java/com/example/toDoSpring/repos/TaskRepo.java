package com.example.toDoSpring.repos;

import org.springframework.data.repository.CrudRepository;
import com.example.toDoSpring.domain.Task;

public interface TaskRepo extends CrudRepository<Task, Integer> {
}
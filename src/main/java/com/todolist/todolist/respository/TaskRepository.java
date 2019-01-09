package com.todolist.todolist.respository;

import com.todolist.todolist.entitity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

}

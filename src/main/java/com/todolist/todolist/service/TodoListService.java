package com.todolist.todolist.service;

import com.todolist.todolist.entitity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoListService {

    void doneTask(int id);

    void undoneTask(int id);

    List<Task> updateTasks(List<Task> tasks);

    Task createTask(Task task);

    void deleteTask(int id);

    List<Task> getTasks();

}

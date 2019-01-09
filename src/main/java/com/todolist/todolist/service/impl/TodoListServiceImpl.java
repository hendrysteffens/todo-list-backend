package com.todolist.todolist.service.impl;

import com.todolist.todolist.entitity.Task;
import com.todolist.todolist.respository.TaskRepository;
import com.todolist.todolist.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TodoListServiceImpl implements TodoListService {

    private static boolean DONE = true;
    private static boolean UNDONE = false;

    @Autowired
    private TaskRepository taskRepository;

    public void doneTask(int id) {
        taskRepository.findById(id).ifPresent(t -> setDoneAndPersist(t, DONE));
    }

    public void undoneTask(int id) {
        taskRepository.findById(id).ifPresent(t -> setDoneAndPersist(t, UNDONE));
    }

    private void setDoneAndPersist(Task task, boolean status) {
        if (status == DONE) //
            task.setConclusionDate(new Date());
        else //
            task.setConclusionDate(null);
        task.setDone(status);
        taskRepository.save(task);
    }

    public List<Task> updateTasks(List<Task> tasks) {
        return StreamSupport.stream(taskRepository.saveAll(tasks.stream().map(t -> updateTask(t)).collect(Collectors.toList())).spliterator(), false).collect(Collectors.toList());
    }

    public Task updateTask(Task task){
        Task entity = taskRepository.findById(task.getId()).orElseThrow(() -> new RuntimeException("Não existe essa tarefa."));
        entity.setDone(task.isDone());
        entity.setTitle(task.getTitle());
        entity.setDescription(task.getDescription());
        entity.setIndex(task.getIndex());
        return entity;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    public List<Task> getTasks() {
        return StreamSupport.stream(taskRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

}

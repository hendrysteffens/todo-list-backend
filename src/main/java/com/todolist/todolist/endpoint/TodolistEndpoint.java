package com.todolist.todolist.endpoint;


import com.todolist.todolist.entitity.Task;
import com.todolist.todolist.service.TodoListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todolist")
@Api(value = "Todolist", description = "Todolist")
public class TodolistEndpoint {

    @Autowired
    private TodoListService todoListService;

    @RequestMapping(method = RequestMethod.GET,//
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)//
    public List<Task> getAllTasks() {
        return todoListService.getTasks();
    }

    @RequestMapping(path = "/{id}",
            method = RequestMethod.DELETE,//
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)//
    public void deleteTask(@PathVariable int id) {
        todoListService.deleteTask(id);
    }

    @RequestMapping(path = "/done/{id}",
            method = RequestMethod.GET,//
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)//
    public void doneTask(@PathVariable int id) {
        todoListService.doneTask(id);
    }

    @RequestMapping(path = "/undone/{id}",
            method = RequestMethod.GET,//
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)//
    public void undoneTask(@PathVariable int id) {
        todoListService.undoneTask(id);
    }

    @RequestMapping(method = RequestMethod.PUT,//
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)//
    public Task save(@RequestBody Task task) {
        return todoListService.createTask(task);
    }

    @RequestMapping(method = RequestMethod.POST,//
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)//
    public List<Task> updateTasks(@RequestBody List<Task> task) {
        return todoListService.updateTasks(task);
    }

}

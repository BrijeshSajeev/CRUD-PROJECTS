package com.example.spring.demoTaskApp.controller;

import com.example.spring.demoTaskApp.entity.Tasks;
import com.example.spring.demoTaskApp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Tasks createTask(@RequestBody Tasks task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Tasks> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Tasks getTaskById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/users/{id}")
    public List<Tasks> getTaskByUserId(@PathVariable int id) {
        return taskService.findByUserId(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id){

        taskService.deleteTaskById(id);

        return "Success";
    }


}

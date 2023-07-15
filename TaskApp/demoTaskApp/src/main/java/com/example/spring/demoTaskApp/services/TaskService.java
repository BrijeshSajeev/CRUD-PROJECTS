package com.example.spring.demoTaskApp.services;

import com.example.spring.demoTaskApp.doa.TasksRepository;
import com.example.spring.demoTaskApp.entity.Tasks;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TasksRepository taskRepository;

    public Tasks createTask(Tasks task) {
        return taskRepository.save(task);
    }

    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    public Tasks getTaskById(int id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + id));
    }

    public List<Tasks> findByUserId(int id) {
        return taskRepository.findTasksByUserId(id);
    }


    public void deleteTaskById(int id){
        taskRepository.deleteById(id);
    }

}

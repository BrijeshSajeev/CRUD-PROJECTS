package com.example.spring.demoTaskApp.controller;

import com.example.spring.demoTaskApp.entity.Tasks;
import com.example.spring.demoTaskApp.entity.Users;
import com.example.spring.demoTaskApp.services.TaskService;
import com.example.spring.demoTaskApp.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServices userService;

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }


    @PutMapping("/{userId}/tasks")
    public String saveNewTasksToCurrentUser(@PathVariable int userId,@RequestBody Tasks tasks){
        Users user=userService.getUserById(userId);
        user.addTasks(tasks);
        userService.addTasksToCurrentUser(user);
        return "Success";

    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
//            Delete User by Id
            userService.deleteUserById(id);

        return "Success";
    }




}

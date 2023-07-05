package com.brijesh.springboot.taskApp.entity;

import org.w3c.dom.ls.LSInput;

import java.util.List;

public class UserDto {
        private int userId;
        private String username;
        private String email;

        private List<Tasks> tasks;

        // Getters and setters


    public UserDto() {
    }

    public UserDto(int userId, String username, String email, List<Tasks> tasks) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.tasks = tasks;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }
}

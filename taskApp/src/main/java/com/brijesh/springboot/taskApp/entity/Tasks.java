package com.brijesh.springboot.taskApp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Tasks {
//    task_id INT PRIMARY KEY AUTO_INCREMENT,
//    description VARCHAR(255) NOT NULL,
//    status ENUM('Pending', 'Completed') DEFAULT 'Pending',
//    user_id INT,
//    FOREIGN KEY (user_id) REFERENCES users(user_id)

    @Id
    @Column(name = "task_id")
    private int taskId;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private boolean status;

    @ManyToOne(cascade={CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private Users user;
    public Tasks() {
    }

    public Tasks(String description, boolean status) {
        this.description = description;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "taskId=" + taskId +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}

package com.example.spring.demoTaskApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Users {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int userId;

        private String username;

        private String email;

        private String password;



        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
        @JsonIgnore
        @ToString.Exclude
        private List<Tasks> tasks;


    public Users(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public void addTasks(Tasks task){
            if (tasks==null)
                tasks=new ArrayList<>();


            task.setUser(this);
            tasks.add(task);
        }

}

package com.example.spring.demoTaskApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int userId;

        private String username;

        private String email;

        private String password;



        @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
        @JsonIgnore
        private List<Tasks> tasks;


        public void addTasks(Tasks task){
            if (tasks==null)
                tasks=new ArrayList<>();
            task.setUser(this);
            tasks.add(task);
        }

}

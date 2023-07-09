package com.example.spring.demoTaskApp.doa;

import com.example.spring.demoTaskApp.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Tasks,Integer> {
}

package com.example.spring.demoTaskApp.doa;

import com.example.spring.demoTaskApp.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TasksRepository extends JpaRepository<Tasks,Integer> {


    @Query("SELECT t FROM Tasks t WHERE t.user.id = :userId")
    public List<Tasks> findTasksByUserId(int userId);

}

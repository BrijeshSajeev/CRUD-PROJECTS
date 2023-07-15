package com.example.spring.demoTaskApp.doa;

import com.example.spring.demoTaskApp.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {
}

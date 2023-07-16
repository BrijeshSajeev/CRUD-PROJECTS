package com.example.spring.demoTaskApp.doa;

import com.example.spring.demoTaskApp.entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users,Integer> {

//    @Query("SELECT u FROM Users u WHERE u.email = :email")
    public Users findByEmail(String email);

}


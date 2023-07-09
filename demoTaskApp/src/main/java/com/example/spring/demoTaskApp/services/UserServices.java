package com.example.spring.demoTaskApp.services;

import com.example.spring.demoTaskApp.doa.UsersRepository;
import com.example.spring.demoTaskApp.entity.Users;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UsersRepository userRepository;

    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }
}

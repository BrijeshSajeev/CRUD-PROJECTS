package com.example.spring.demoTaskApp.services;

import com.example.spring.demoTaskApp.doa.UsersRepository;
import com.example.spring.demoTaskApp.entity.Users;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Users> theResult=userRepository.findById(id);
        Users user=null;

        if (theResult.isPresent()){
            user=theResult.get();
        }

        return user;

    }

    public void addTasksToCurrentUser(Users user){
        userRepository.save(user);
    }

}

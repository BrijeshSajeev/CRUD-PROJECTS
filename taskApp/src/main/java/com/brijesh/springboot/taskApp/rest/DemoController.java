package com.brijesh.springboot.taskApp.rest;

import com.brijesh.springboot.taskApp.doa.UserDoa;
import com.brijesh.springboot.taskApp.doa.UserJpaRepo;
import com.brijesh.springboot.taskApp.entity.Tasks;
import com.brijesh.springboot.taskApp.entity.UserDto;
import com.brijesh.springboot.taskApp.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/demo")
public class DemoController {


    @Autowired
    private UserDoa userDoa;

    @Autowired
    private UserJpaRepo userJpaRepo;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello world";
    }

    @GetMapping("/users/{id}")
    public Users displayAllUser(@PathVariable int id){

        Users theUser=userDoa.findUserWithTasksById(id);
        return theUser;

    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserWithTasks(@PathVariable int userId) {
        Optional<Users> userOptional = userJpaRepo.findUserWithTasksById(userId);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            List<Tasks> tasks = user.getTasks();
            UserDto userWithTasksDTO = new UserDto(user.getUserId(), user.getUsername(), user.getEmail(), tasks);
            return ResponseEntity.ok(userWithTasksDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}

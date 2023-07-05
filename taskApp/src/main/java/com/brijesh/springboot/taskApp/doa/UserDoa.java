package com.brijesh.springboot.taskApp.doa;

import com.brijesh.springboot.taskApp.entity.Tasks;
import com.brijesh.springboot.taskApp.entity.Users;
import org.apache.catalina.User;

import java.util.List;

public interface UserDoa {

    void addUserAndTask(Users theUser);
//    User displayUserByUserId(User)
    Users findUserWithTasksById(int userId);

}

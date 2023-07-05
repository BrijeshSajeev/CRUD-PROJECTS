package com.brijesh.springboot.taskApp;

import com.brijesh.springboot.taskApp.doa.UserDoa;
import com.brijesh.springboot.taskApp.entity.Tasks;
import com.brijesh.springboot.taskApp.entity.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TaskAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserDoa userService){
		return runner->{
//			insertUser(userService);
//			displayUsers(userService);
//			findUser(userService);


		};


	}

	private void findUser(UserDoa userService) {
		Users theUser=userService.findUserWithTasksById(1);

		System.out.println(theUser);
		System.out.println(theUser.getTasks());

	}

	private void displayUsers(UserDoa userService) {



	}

	private void insertUser(UserDoa userService) {

		Users user1=new Users( "John Doe", "johndoe@example.com", "password123");
		Users user2=new Users("Jane Smith", "janesmith@example.com", "password456");
		Users user3=new Users("Mike Johnson", "mikejohnson@example.com", "password789");

		user1.addTask(new Tasks("Complete project proposal",true));
		user2.addTask(new Tasks("Prepare presentation slides",false));
		user3.addTask(new Tasks("Review code changes",false));

		userService.addUserAndTask(user1);
		userService.addUserAndTask(user2);
		userService.addUserAndTask(user3);


	}
}

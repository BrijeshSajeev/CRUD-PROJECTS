package com.example.spring.demoTaskApp;

import com.example.spring.demoTaskApp.entity.Tasks;
import com.example.spring.demoTaskApp.entity.Users;
import com.example.spring.demoTaskApp.services.TaskService;
import com.example.spring.demoTaskApp.services.UserServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoTaskAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTaskAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserServices userServices, TaskService taskService){

		return runner->{

//			addTaskToTheUser(userServices,taskService);
		};

	}

	private void addTaskToTheUser(UserServices userServices, TaskService taskService) {

		int id=3;
		Users user=userServices.getUserById(id);
		System.out.println(user);

		List<Tasks> tasks=taskService.findByUserId(id);
		user.setTasks(tasks);
		Tasks newTask=new Tasks("Cook",true);
		Tasks newTask1=new Tasks("wash",false);

		user.addTasks(newTask);
		user.addTasks(newTask1);

		System.out.println(user.getTasks());

		userServices.addTasksToCurrentUser(user);






	}


}

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


}

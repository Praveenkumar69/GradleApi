package com.RestApi.GradleApi;

import com.RestApi.GradleApi.entities.User;
import com.RestApi.GradleApi.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class GradleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradleApiApplication.class, args);
	}
//	@Bean
//	CommandLineRunner run(UserService userService){
//		return  args -> {
//			userService.saveUser(new User(null,"Rohan gupta", "ro@gmail.com","1234","1234"));
//			userService.saveUser(new User(null,"kamal gupta", "ko@gmail.com","1234","1234"));
//		};
//	}

}

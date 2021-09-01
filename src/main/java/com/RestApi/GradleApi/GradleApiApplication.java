package com.RestApi.GradleApi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
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
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}

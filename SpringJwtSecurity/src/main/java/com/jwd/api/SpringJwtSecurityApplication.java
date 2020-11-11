package com.jwd.api;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.jwd.api.entity.User;
import com.jwd.api.repository.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages = "com.jwd.api")
public class SpringJwtSecurityApplication {
	
	@Autowired
	private UserRepository userRepo;
	public static void main(String[] args) {
		SpringApplication.run(SpringJwtSecurityApplication.class, args);
	}
	
	@PostConstruct
	public void loadUsers() {
		User user = new User(101,"Kannan","sbk","sbk@gmail.com");
		User user1 = new User(102,"Valar","sbk","valar@gmail.com");
		User user2 = new User(103,"Banu","sbk","banu@gmail.com");
		userRepo.save(user);
		userRepo.save(user1);
		userRepo.save(user2);
	}
}

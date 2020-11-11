package com.rolesec.api;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rolesec.api.entity.Role;
import com.rolesec.api.entity.User;
import com.rolesec.api.repository.UserRepository;

@SpringBootApplication
public class SpringRoleBasedsecurityApplication {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder pwdEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRoleBasedsecurityApplication.class, args);
	}
	
	@PostConstruct
	public void loadInitUsers() {
		
		String password = pwdEncoder.encode("sbk");
		Set<Role> role = new HashSet<Role>();
		role.add(new Role(1,"ADMIN"));
		User u1 = new User(100,"Kannan",password,"sbk@gmail.com", role);
		userRepo.save(u1);
		System.out.println("Application started");
	}
}

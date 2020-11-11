package com.rolesec.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rolesec.api.entity.User;
import com.rolesec.api.repository.UserRepository;

@RestController
public class AdminController {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@PreAuthorize("hasAnyRole('ADMIN')") 
	@PostMapping("/addNewUser")
	public String addNewUser(@RequestBody User user) {
		String password = user.getPassword();
		String enPassword = passwordEncoder.encode(password);
		user.setPassword(enPassword);
		userRepo.save(user);
		return "User added successfully !!!";
	}
	
	@GetMapping("/viewUsers")
	public List<User> getUsers() {
		System.out.println("View User Called");
		return userRepo.findAll();
	}
}

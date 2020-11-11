package com.jwd.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwd.api.dto.AuthRequest;
import com.jwd.api.util.JwtUtils;

@RestController
public class UserController {
	
	
	@Autowired
	private JwtUtils jwtUtil;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome !!!";
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authReq) {
		authManager.authenticate(new UsernamePasswordAuthenticationToken(authReq.getUserName(), authReq.getPassword()));
		return jwtUtil.generateToken(authReq.getUserName());
	}
}

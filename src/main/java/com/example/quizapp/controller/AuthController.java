package com.example.quizapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.entity.User;
import com.example.quizapp.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	 private final UserService userService;

	    public AuthController(UserService userService) {
	        this.userService = userService;
	    }

	    // Register user
	    @PostMapping("/register")
	    public ResponseEntity<User> register(@RequestBody User user) {
	        return ResponseEntity.ok(userService.registerUser(user));
	    }
	    
	    @PostMapping("/login")
	    public ResponseEntity<String> login() {
	        return ResponseEntity.ok("Login successful");
	    }
}

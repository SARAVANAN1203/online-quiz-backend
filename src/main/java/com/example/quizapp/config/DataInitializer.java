package com.example.quizapp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.quizapp.entity.Role;
import com.example.quizapp.entity.User;
import com.example.quizapp.repository.UserRepository;

@Configuration
public class DataInitializer {

	   @Bean
	    CommandLineRunner initAdmin(UserRepository userRepository,
	                                PasswordEncoder passwordEncoder) {

	        return args -> {
	            if (userRepository.findByUsername("admin").isEmpty()) {
	                User admin = new User();
	                admin.setUsername("admin");
	                admin.setEmail("admin@gmail.com");
	                admin.setPassword(passwordEncoder.encode("admin123"));
	                admin.setRole(Role.ADMIN);

	                userRepository.save(admin);
	            }
	        };
	    }
}

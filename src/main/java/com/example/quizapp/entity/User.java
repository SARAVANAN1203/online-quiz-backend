package com.example.quizapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {

	 @Id @GeneratedValue
	 private Long id;
	 private String username;
	 private String password;
	 private String email;

	 @Enumerated(EnumType.STRING)
	 private Role role;

	 
	 public User() {
		 
	 }
	 
	 
	 /**
	 * @param id
	 * @param username
	 * @param password
	 * @param email
	 * @param role
	 */
	public User(Long id, String username, String password, String email, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}


	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public String getUsername() {
		 return username;
	 }

	 public void setUsername(String username) {
		 this.username = username;
	 }

	 public String getPassword() {
		 return password;
	 }

	 public void setPassword(String password) {
		 this.password = password;
	 }

	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }

	 public Role getRole() {
		 return role;
	 }

	 public void setRole(Role role) {
		 this.role = role;
	 }
	 
	 
}

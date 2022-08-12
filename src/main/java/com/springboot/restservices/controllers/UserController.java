package com.springboot.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restservices.entities.User;
import com.springboot.restservices.services.UserServices;

//Controller

@RestController
public class UserController {
	
	// Autowire the Userservice
	
	@Autowired
	private UserServices userServices;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userServices.getAllUsers();
		
	}
	
	//Create User Method
	//@RequestBody Annotation
	//@PostMapping Annotation
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userServices.createUser(user);
	}
	
	// getUserById
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id){
		return userServices.getUerById(id);
		
	}
	
	// updateUserById
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable("id") Long id, @RequestBody User user) {
		return userServices.updateUserById(id, user);
		
	}
	
	//deleteUserById
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		userServices.deleteUserById(id);
	}
	
	// getUserByUsername
	@GetMapping("/users/byusername/{username}")
	public User getUserByUsername(@PathVariable("username")String username) {
		return userServices.getUserByUsername(username);
	}
	
	
	
	
}

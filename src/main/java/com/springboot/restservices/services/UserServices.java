package com.springboot.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.restservices.entities.User;
import com.springboot.restservices.exceptions.UserExistsException;
import com.springboot.restservices.exceptions.UserNotFoundException;
import com.springboot.restservices.repositories.UserRepository;

// Service

@Service
public class UserServices {

	// Autowire the UserRepository
	
	@Autowired
	private UserRepository userRepository;
	
	// getAllUsers Method
		public List<com.springboot.restservices.entities.User> getAllUsers(){
		return userRepository.findAll();
	}
	
	// CreateUser Method
		public User createUser(User user) throws UserExistsException {
			//if user exist using username
			User existingUser = userRepository.findByUsername(user.getUsername());
			// if not exists throw UserExistsException
			if (existingUser != null) {
				throw new UserExistsException("User already exits in repository");
			}
			
			return userRepository.save(user);
		
	}

	//getUserByID
		public Optional<User> getUerById(Long id)throws UserNotFoundException {
			Optional<User> user = userRepository.findById(id);
			if(!user.isPresent())
			{
				throw new UserNotFoundException("User not found in user Repository");
			}
			return user;
		}
	
	//updateUserById
		public User updateUserById(Long id, User user) throws UserNotFoundException {
			Optional<User> optionalUser = userRepository.findById(id);
			if(!optionalUser.isPresent())
			{
				throw new UserNotFoundException("User not found in user Repository, provide the correct user id");
			}
			
			user.setId(id);
			return userRepository.save(user);
		}
		
	//deleteUserById
		public void deleteUserById(Long id) {
			Optional<User> optionalUser = userRepository.findById(id);
			if(!optionalUser.isPresent())
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found in user Repository, provide the correct user id");
			}
						
			userRepository.deleteById(id);
			
		}
		
		
	// getUserByUsername
		
		public User getUserByUsername(String username) {
			return userRepository.findByUsername(username);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}

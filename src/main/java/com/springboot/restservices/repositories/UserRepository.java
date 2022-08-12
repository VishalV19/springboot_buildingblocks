package com.springboot.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.restservices.entities.User;

//Repository


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	// Implementing "findBYUsername" method using Spring DATA JPA
	
	

	User findByUsername(String username);

}

package com.springboot.restservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
 
	// Simple method
	// URI - /helloworld
	// GET 
	
	
	// @RequestMapping(method = RequestMethod.GET, path = "/helloworld")
	   @GetMapping("helloworld1")
	public String helloWorld() {
		return "Hello World";
		
	}
	   @GetMapping("/helloworld-bean")
	   public UserDetails helloWorldBean () {
		   
		   return new UserDetails("Vishal", "Singh", "Chennai");
	   }
	
}

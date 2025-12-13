package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.GreetingService;

@RestController
public class GreetController {
	
	@Autowired
	GreetingService grservice;
	
	@GetMapping("/greet")
	public String greet() {
		return grservice.greet();
	}
	
}

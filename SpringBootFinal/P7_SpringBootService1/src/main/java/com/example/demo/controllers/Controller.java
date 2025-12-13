package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.User;

@RestController
@RequestMapping("user")
public class Controller {
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello user...";
	}
	
	@GetMapping("/getuser")
	public User getUser() {
		return new User(1,"Omkar","omkar123");
	}
	
}

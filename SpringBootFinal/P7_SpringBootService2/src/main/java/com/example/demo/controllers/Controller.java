package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entites.User;

@RestController
@RequestMapping("/admin")
public class Controller {
	
	@Autowired
	RestTemplate rt;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome admin";
	}
	
	@GetMapping("/getuser")
	public ResponseEntity<User> getuser() {
		//comm with service 1, get user instance, send it in the response
		ResponseEntity<User> res = rt.getForEntity("http://localhost:8081/user/getuser", User.class);
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody());
		return res;
		
	}
	
}

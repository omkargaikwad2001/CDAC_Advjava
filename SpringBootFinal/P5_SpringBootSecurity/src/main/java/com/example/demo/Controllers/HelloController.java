package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/all")
	public String all() {
		return "public data - available for all";
	}
	
	
	@GetMapping("/user")
	public String user() {
		return "user data - available for authenticated user";
	}
	
	
	@GetMapping("/admin")
	public String admin() {
		return "admin data - available for admins";
	}
	
}

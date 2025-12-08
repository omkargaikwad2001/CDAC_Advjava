package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/greet")
	@ResponseBody
	public String greet() {
		return "Hello User...";
	}
	
	@GetMapping("/nums")
	@ResponseBody
	public List<Integer> numbers(){
		List<Integer> nums = Arrays.asList(10,20,30,40,50);
		return nums;
	}
	
}

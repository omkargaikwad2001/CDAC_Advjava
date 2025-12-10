package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:5173/")
public class CategoryController {

	@Autowired
	CategoryService cservice;
	
	@GetMapping("/all")
	public List<Category> getAllCategories(){
		List<Category> allCategories = cservice.getAllCategories();
		return allCategories;
	}
	
	@GetMapping("/getone/{id}")
	public Category getOneCategory(@PathVariable int id) {
		Category oneCategory = cservice.getOneCategory(id);
		return oneCategory;
	}
	
	//saving master with child
	@PostMapping("/save")
	public Category saveCategory(@RequestBody Category cat) {
		return cservice.saveCategory(cat);
	}
	
	
	
}

package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.repositoris.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository crepo;

	public List<Category> getAllCategories() {
		List<Category> all = crepo.findAll();
		return all;
	}

	public Category getOneCategory(int id) {
		Category ct = null;
		Optional<Category> byId = crepo.findById(id);

		try {
			ct = byId.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;

	}
	
	//Saving master with child (Both are new)
	public Category saveCategory(Category cat) {
		return crepo.save(cat);
	}
	
	
	
}

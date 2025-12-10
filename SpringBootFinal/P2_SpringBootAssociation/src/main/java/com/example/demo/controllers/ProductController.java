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
import com.example.demo.entities.Product;
import com.example.demo.entities.ProductDummy;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:5173/")
public class ProductController {

	@Autowired
	ProductService pservice;
	
	@Autowired
	CategoryService cservice;
	
	@GetMapping("/all")
	public List<Product> getAllProducts(){
		List<Product> allProducts = pservice.getAllProducts();
		return allProducts;
	}
	
	@GetMapping("/getone/{id}")
	public Product getOneProduct(@PathVariable int id) {
		return pservice.getOneProduct(id);
	}
	
	//saving child with master (both are new)
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product pro) {
		return pservice.saveProduct(pro);
	}
	
	//saving child with existing master
	@PostMapping("/savewithmaster")
	public Product saveProductWithMaster(@RequestBody ProductDummy p) {
		
		Category oneCategory = cservice.getOneCategory(p.getCat_id());
		
		Product pr = new Product();
		
		pr.setP_name(p.getP_name());
		pr.setP_description(p.getP_description());
		pr.setP_price(p.getP_price());
		pr.setCategory(oneCategory);
		
		pservice.saveProduct(pr);
		
		return pr;
	}
}

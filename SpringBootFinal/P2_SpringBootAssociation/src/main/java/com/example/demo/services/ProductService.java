package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Product;
import com.example.demo.repositoris.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository prepo;

	public List<Product> getAllProducts() {
		List<Product> all = prepo.findAll();
		return all;
	}

	public Product getOneProduct(int id) {
		Product pro = null;
		Optional<Product> byId = prepo.findById(id);

		try {

			pro = byId.get();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pro;
	}
	
	public Product saveProduct(Product pro) {
		return prepo.save(pro);
	}
	
	

}

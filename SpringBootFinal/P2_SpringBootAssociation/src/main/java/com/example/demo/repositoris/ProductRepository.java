package com.example.demo.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}

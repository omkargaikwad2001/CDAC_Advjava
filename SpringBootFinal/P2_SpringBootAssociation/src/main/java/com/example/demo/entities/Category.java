package com.example.demo.entities;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer c_id;

	String c_name;
	
	String c_description;
	
	@JsonIgnoreProperties("category")
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	Set<Product> products;

	public void setProducts(Set<Product> products) {
		for(Product p:products) {
			p.setCategory(this);
		}
		this.products = products;
	}

}

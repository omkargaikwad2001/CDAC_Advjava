package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer pid;
	
	String name;
	
	Float price;
	
	@ManyToOne
	@JoinColumn(name = "catid")
	Category catid;

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public Products(String name, Float price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Products(Integer pid, String name, Float price, Category catid) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.catid = catid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Category getCatid() {
		return catid;
	}

	public void setCatid(Category catid) {
		this.catid = catid;
	}

}

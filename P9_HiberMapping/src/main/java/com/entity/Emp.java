package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name="emp")
@Inheritance(strategy = InheritanceType.JOINED)
public class Emp {
	
	@Id
	Integer id;
	
	String name;
	
	String email;
	
	String contactno;
	
	Float basic;

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(Integer id, String name, String email, String contactno, Float basic) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactno = contactno;
		this.basic = basic;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public Float getBasic() {
		return basic;
	}

	public void setBasic(Float basic) {
		this.basic = basic;
	}
	
}

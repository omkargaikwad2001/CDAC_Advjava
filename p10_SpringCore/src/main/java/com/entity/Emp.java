package com.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Emp {
	
	Integer id;
	
	Name name;
	
	Address address;
	
	List<String> emails;

//	public Emp() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Emp(Integer id, Name name, Address address, List<String> emails) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.address = address;
//		this.emails = emails;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public Name getName() {
//		return name;
//	}
//
//	public void setName(Name name) {
//		this.name = name;
//	}
//
//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
//
//	public List<String> getEmails() {
//		return emails;
//	}
//
//	public void setEmails(List<String> emails) {
//		this.emails = emails;
//	}

//	@Override
//	public String toString() {
//		return "Emp [id=" + id + ", name=" + name + ", address=" + address + ", emails=" + emails + "]";
//	}


}

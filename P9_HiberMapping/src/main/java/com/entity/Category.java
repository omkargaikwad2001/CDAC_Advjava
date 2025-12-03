package com.entity;

import java.util.Set;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	Integer cid;
	
	String cname;
	
	String cdesc;
	
	@OneToMany(mappedBy = "catid")
	@Cascade(value =  CascadeType.ALL)
	Set<Products> items;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Integer cid, String cname, String cdesc) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cdesc = cdesc;
	}

	public Category(Integer cid, String cname, String cdesc, Set<Products> items) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cdesc = cdesc;
		this.items = items;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCdesc() {
		return cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	public Set<Products> getItems() {
		return items;
	}

	public void setItems(Set<Products> items) {
		//for fk column null vale will not get inserted
		for(Products p : items) {
			p.setCatid(this);
		}
		this.items=items;
	}
	

}

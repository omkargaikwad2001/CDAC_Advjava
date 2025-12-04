package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tempemp")
@PrimaryKeyJoinColumn(name = "eid")
public class TemporaryEmp extends Emp {
	
	Float extrapay;
	
	Float taxes;

	public TemporaryEmp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TemporaryEmp(Integer id, String name, String email, String contactno, Float basic) {
		super(id, name, email, contactno, basic);
		// TODO Auto-generated constructor stub
	}
	
	public TemporaryEmp(Integer id, String name, String email, String contactno, Float basic,Float extrapay, Float taxes) {
		super(id, name, email, contactno, basic);
		this.extrapay = extrapay;
		this.taxes = taxes;
	}

	public TemporaryEmp(Float extrapay, Float taxes) {
		super();
		this.extrapay = extrapay;
		this.taxes = taxes;
	}

	public Float getExtrapay() {
		return extrapay;
	}

	public void setExtrapay(Float extrapay) {
		this.extrapay = extrapay;
	}

	public Float getTaxes() {
		return taxes;
	}

	public void setTaxes(Float taxes) {
		this.taxes = taxes;
	}
	
}

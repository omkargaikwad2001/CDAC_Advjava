package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "peremp")
@PrimaryKeyJoinColumn(name = "eid") //id property of super class

public class PermanentEmp extends Emp{

	Float allowance;
	
	Float bonus;
	
	Float deduction;

	public PermanentEmp() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public PermanentEmp(Integer id, String name, String email, String contactno, Float basic) {
		super(id, name, email, contactno, basic);
		// TODO Auto-generated constructor stub
	}
	
	public PermanentEmp(Integer id, String name, String email, String contactno, Float basic,Float allowance, Float bonus, Float deduction) {
		super(id, name, email, contactno, basic);
		this.allowance = allowance;
		this.bonus = bonus;
		this.deduction = deduction;
	}


	public PermanentEmp(Float allowance, Float bonus, Float deduction) {
		super();
		this.allowance = allowance;
		this.bonus = bonus;
		this.deduction = deduction;
	}

	public Float getAllowance() {
		return allowance;
	}

	public void setAllowance(Float allowance) {
		this.allowance = allowance;
	}

	public Float getBonus() {
		return bonus;
	}

	public void setBonus(Float bonus) {
		this.bonus = bonus;
	}

	public Float getDeduction() {
		return deduction;
	}

	public void setDeduction(Float deduction) {
		this.deduction = deduction;
	}
	
}

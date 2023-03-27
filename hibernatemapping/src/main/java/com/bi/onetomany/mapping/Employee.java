package com.bi.onetomany.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id")
	 private int id;
	 
	 @Column(name="name")
	 private String name;
	 
	 @ManyToOne(cascade= {CascadeType.PERSIST,CascadeType.MERGE,
			              CascadeType.DETACH,CascadeType.REFRESH})
	 @JoinColumn(name="company_id")
	 private Company company;
	 
	 public Employee() {
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name +"]";
	}
	  

}

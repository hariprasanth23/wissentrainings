package com.bi.onetomany.mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="location")
	private String location;
	
	@OneToMany(mappedBy="company",cascade= {CascadeType.PERSIST,CascadeType.MERGE,
             CascadeType.DETACH,CascadeType.REFRESH})
	private List<Employee> employees;
	 
	 public Company() {
	
	 }

	public Company(String name, String location) {
		super();
		this.name = name;
		this.location = location;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", location=" + location + "]";
	}
	 
	 public void add(Employee emp) {
		 
		 if(employees==null) {
			 employees= new ArrayList<>();
		 }
		 
		 employees.add(emp); 
		 
		 emp.setCompany(this);
	 }

}

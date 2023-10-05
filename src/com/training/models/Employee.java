package com.training.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee implements Serializable {
	//data members
	private int id;
	private String name;
	private double salary;
	private LocalDate doj;
	private String dept;
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public Employee(int id, String name, double salary, LocalDate doj, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.doj = doj;
		this.dept = dept;
	}
	public Employee(int id, String name, double salary, LocalDate doj) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.doj = doj;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", doj=" + doj +dept+ "]";
	}
	
	
	

}

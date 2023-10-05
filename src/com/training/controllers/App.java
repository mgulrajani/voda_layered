package com.training.controllers;

import java.time.LocalDate;

import com.training.exceptions.IdNotFoundException;
import com.training.models.Employee;
import com.training.services.EmployeeService;
import com.training.services.IEmployeeService;

public class App {
	public static void main(String[] args) {
		
		 IEmployeeService service = new EmployeeService();
		System.out.println(service.addEmployee(new 
				Employee(111,"jaya",400000,LocalDate.now())));
	    try {
			service.updateEmployee(111,new
					Employee(111,"gayatri",343434,LocalDate.now()));
		
		System.out.println(service.getAllEmployees());
		
		System.out.println(service.getEmployeeById(111));
		
		System.out.println(service.deleteEmployee(111));
		
	}
		 catch (IdNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	

}}

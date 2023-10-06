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
				Employee("meenal",3400000,LocalDate.now(),"Customer service")));
		service.addEmployee(new 
				Employee("suresh",4800000,LocalDate.now().minusYears(2),"Legal Head"));
		 System.out.println(service.getAllEmployees());
		 
				  try { service.updateEmployee(111,new
				  Employee(111,"gayatri",343434,LocalDate.now(),"Finance"));
				  
				  
				  System.out.println(service.getEmployeeById(112));
				  
				  System.out.println(service.deleteEmployee(112));
				  
				  } catch (IdNotFoundException e) { // TODO Auto-generated catch block
				  e.printStackTrace(); }
				  
				 
}}

package com.training.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.training.exceptions.IdNotFoundException;
import com.training.models.Employee;

public class EmployeeRepoLinkedList implements IEmployeeRepo{
   List<Employee> list =  new ArrayList<>();
   
	@Override
	public Employee addEmployee(Employee e) {
		// TODO Auto-generated method stub
		
		list.add(e);
		
		return e;
	}

	@Override
	public Employee updateEmployee(int id, Employee e)
			throws IdNotFoundException {
		// TODO Auto-generated method stub
		
		for(Employee e1: list) {
			if(e1.getId()==id) {
				
				e1.setDept(e.getDept());
				e1.setDoj(e.getDoj());
				e1.setId(e.getId());
				e1.setName(e.getName());
				e1.setSalary(e.getSalary());
				
				
			}
			
		}
		return e;
	}

	@Override
	public Employee deleteEmployee(int id)
			throws IdNotFoundException {
		// TODO Auto-generated method stub
		Employee e = null;
		for(Employee e1: list) {
			if(e1.getId()==id) {
				e=e1;
			
			}}
	  list.remove(e);
		return e;
			
	}

	@Override
	public Employee getEmployeeById(int id) 
						throws IdNotFoundException {
		// TODO Auto-generated method stub
		for(Employee e1: list) {
			if(e1.getId()==id) {
			  return e1;
			}
			else {
				throw new IdNotFoundException("id not found");
			}
	}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return list;
	}

}

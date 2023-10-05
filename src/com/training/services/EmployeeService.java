package com.training.services;

import java.util.List;

import com.training.exceptions.IdNotFoundException;
import com.training.models.Employee;
import com.training.repo.EmployeeRepoLinkedList;
import com.training.repo.IEmployeeRepo;
//service layer is dependent upon repo layer 

public class EmployeeService implements IEmployeeService {
  // today we will use linkedlist , in mem solution for crud of employee  -our model
	private IEmployeeRepo  repo = new  EmployeeRepoLinkedList();
//service has a repo object
	//has a relationship
	//service has a repo 
	@Override
	public Employee addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return repo.addEmployee(e);
	}

	@Override
	public Employee updateEmployee(int id, Employee e) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return repo.updateEmployee(id, e);
		
	}

	@Override
	public Employee deleteEmployee(int id) 
						throws IdNotFoundException {
		// TODO Auto-generated method stub
		return repo.deleteEmployee(id);
	}

	@Override
	public Employee getEmployeeById(int id) 
							throws IdNotFoundException {
		// TODO Auto-generated method stub
		return repo.getEmployeeById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repo.getAllEmployees();
	}

}

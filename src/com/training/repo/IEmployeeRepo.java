package com.training.repo;

import java.util.List;

import com.training.exceptions.IdNotFoundException;
import com.training.models.Employee;

public interface IEmployeeRepo {
	//POST
	//insert into employees values( )
	public Employee addEmployee(Employee e);
	//PUT
	//update employees set name= ,sal ,dept where 
	public Employee updateEmployee(int id,Employee e) throws IdNotFoundException;
	//DELETE
	//delete from employees where id=?
	public Employee deleteEmployee(int id) throws IdNotFoundException ;
	//RETRIEVE by id
	//select * from employees where id = ?
	public Employee getEmployeeById(int id) throws IdNotFoundException;
	
	//Retrieve all -- select * from employees;
	public List<Employee> getAllEmployees();
	

}

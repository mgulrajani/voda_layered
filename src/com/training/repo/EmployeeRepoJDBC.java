package com.training.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.training.exceptions.IdNotFoundException;
import com.training.models.Employee;
import com.training.utils.ConnectionManager;

public class EmployeeRepoJDBC  implements IEmployeeRepo{
    //we will use our own Singleton class to get the instance of java.sql.Connection
	private static Connection connection = ConnectionManager.getConnection();
	
	@Override
	public Employee addEmployee(Employee e) {
		//1st questionmark name  -- String
		//2nd ? salary   double
		//3rd ? doj  -LocalDate
		//4? dept   -String
		String sql =  "insert into employees(name,salary,doj,dept) values(?,?,?,?)";
		
		java.sql.Date doj2 = java.sql.Date.valueOf(e.getDoj());
		try {
			PreparedStatement ps =  
					connection.prepareStatement(sql);
		   // ps.setInt(1, e.getId());
			ps.setString(1, e.getName());
		    ps.setDouble(2, e.getSalary());
		    ps.setDate(3, doj2);
		    ps.setString(4, e.getDept());
		    
		    int retValue = ps.executeUpdate();
		    
		    if(retValue == 1) {
		    	System.out.println("Record added successfully");
		    	return e;
		    }
		    
		
		
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return e;
	}

	@Override
	public Employee updateEmployee(int id, Employee e) throws IdNotFoundException {
		// TODO Auto-generated method stub
		//first we will retrieve the employee object to be modified
		Employee empToBeUpdated =  getEmployeeById(id);
		
		String sql = "update employees "
				+ "set name=?,dept=? "
				+ "where id =?";
		
		
		//update employees
	  //set col =new ,col =new where id = ?
		 
		
		try {
			PreparedStatement ps =  connection.prepareStatement(sql);
			ps.setString(1, e.getName());
			ps.setString(2, e.getDept());
			ps.setInt(3, id);
			
			int retVal = ps.executeUpdate();
			if(retVal == 1) {
				System.out.println("successful updation");
				return e;
				
			}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return e;
	}

	@Override
	public Employee deleteEmployee(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
	   Employee toBeDel = getEmployeeById(id);
	   
		String sql ="delete from employees where id = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			int val =  ps.executeUpdate();
			if (val ==1) {
			  System.out.println("record deleted");	
			}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return toBeDel;
		
	}

	@Override
	public Employee getEmployeeById(int id) throws IdNotFoundException {
		String sql ="select * from employees where id = ?";
		ResultSet rs = null;
		Employee ee=null;
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
		
			while(rs.next()) {
				int idd=rs.getInt(1);
				String name = rs.getString(2);
				Double salary =  rs.getDouble(3);
				LocalDate doj=rs.getDate(4).toLocalDate();
				String dept =  rs.getString(5);
				
				 ee=new Employee(idd,name,salary,doj,dept);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ee;
	}

	@Override
	public List<Employee> getAllEmployees() {
	  List<Employee> empList = new ArrayList<>();
	  
	  String sql = "select * from employees";
	  ResultSet rs =null;
	  
	  try {
		Statement statement =  connection.createStatement();
		
		rs = statement.executeQuery(sql);
		
		while(rs.next()) {
			int id =rs.getInt(1);
			String name = rs.getString(2);
			Double salary =  rs.getDouble(3);
			LocalDate doj=rs.getDate(4).toLocalDate();
			String dept =  rs.getString(5);
			
			Employee e=new Employee(id,name,salary,doj,dept);
			
			empList.add(e);
			
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
	  
	  
	  return empList;
	}

}

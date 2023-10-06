package com.training.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//for the second step , to obtain the Connection object 

//sole purpose of this class is to give me a Connection object
//problem and context : throughout the app I want just one instance /object of java.sql.Connection 
//solution is : design pattern -- Singleton design pattern 
//creational aspect - i just want to create one and only one instance of Connection in jvm --Singleton
public class ConnectionManager {

	private static Connection connection= null;
	
	private ConnectionManager() {}
	
	public static Connection getConnection() {
		
		try {
			connection=
					DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");				
		     
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
	//no public constructor if I want Singleton
	
	
public static void main(String[] args) {
System.out.println(getConnection());
}
	
}

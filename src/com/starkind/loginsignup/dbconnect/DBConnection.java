package com.starkind.loginsignup.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	private static final String name = "sa";
	private static final String password = "";
	private static final String driver = "org.h2.Driver";
	private static final String url = "jdbc:h2:tcp://localhost/~/NIIT_Training";
	
	private DBConnection()
	{
		//private constructor to restrict using new keyword
		
	}
	
	public static Connection getDBConnection()
	{
		//load the driver class
		try 
		{
			Class.forName(driver);
			//get connection from DriverManager
			return DriverManager.getConnection(url, name, password);
		} 
		catch (ClassNotFoundException | SQLException e) //from java1.7 onwards
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//close the connection
	public static void closeConnection(Connection con)
	{
		try 
		{
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	
}

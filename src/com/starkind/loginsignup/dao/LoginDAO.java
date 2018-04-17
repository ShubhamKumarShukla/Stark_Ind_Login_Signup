package com.starkind.loginsignup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.starkind.loginsignup.dbconnect.DBConnection;

public class LoginDAO 
{
	public boolean validate(String id, String password)
	{
		Connection con = DBConnection.getDBConnection();
		
	 	try 
	 	{
	 		String query = "select * from user where name = ? and password = ?"; 	
	 		PreparedStatement pst = con.prepareStatement(query);
	 		pst.setString(1, id);
	 		pst.setString(2, password);
			ResultSet result = pst.executeQuery();
			if(result.next())
				return true;
			else
				return false;
		} 
	 	catch (SQLException e) 
	 	{
			e.printStackTrace();
			return false;
		}
	}
}

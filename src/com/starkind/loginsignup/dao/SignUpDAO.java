package com.starkind.loginsignup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.starkind.loginsignup.dbconnect.DBConnection;

public class SignUpDAO 
{
	public int insertUser(String email, String uname, String password, String mob, String addr)
	{
		Connection con = DBConnection.getDBConnection();
		
	 	try 
	 	{
	 		String query = "insert into user values(?,?,?,?,?)"; 	
	 		PreparedStatement pst = con.prepareStatement(query);
	 		pst.setString(1, email);
	 		pst.setString(2, uname);
	 		pst.setString(3, password);
	 		pst.setString(4, mob);
	 		pst.setString(5, addr);
			int i = pst.executeUpdate();
			return i;
			
		} 
	 	catch (SQLException e) 
	 	{
			e.printStackTrace();
			return 0;
		}
	}
}

package com.starkind.loginsignup.dbconnect;

import java.sql.Connection;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DBConnection con = new DBConnection();
		Connection con2 = DBConnection.getDBConnection();
		
		/*DBConnection.closeConnection(con);*/
		
		if(con2==null)
			System.out.println("Could not connect to db");
		else
			System.out.println("Connection established successfully");
	}

}

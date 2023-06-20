package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class DBUtil{
	
	private static Connection con;
	
	public static Connection getMyConnection()
	{
		try {
				if(con==null){
			
					DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
					String url="jdbc:mysql://192.168.10.150:3306/dac22_campus?useSSL=false";
					con=DriverManager.getConnection(url,"dac22","welcome");
						if(con!=null)
						{
							System.out.println("Connection Done.....");
						}
						
					}
					return con;	
					
			} catch (SQLException e) {
					System.out.println("ERROR OCCURED...");
					return null;
			}
		}
	
	public static void closeConnection()
	{
		try {
			if(con!=null)
			con.close();
		} catch (SQLException e) {
			
			System.out.println("connection closed");
		}
	}
	
	
		
		
	
	
}

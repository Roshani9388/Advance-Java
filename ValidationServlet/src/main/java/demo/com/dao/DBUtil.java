package demo.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static Connection conn;
	
	public static Connection getMyConnection(){
		
		try {
				if(conn==null){
						System.out.println("connection done");
					DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
					String url="jdbc:mysql://192.168.10.150:3306/dac22_campus";
					conn=DriverManager.getConnection(url,"dac22","welcome");
				
					if(conn!=null){
						System.out.println("Connection done...");
					}
					return conn;
				}
				
			} catch (SQLException e) {
				
				System.out.println("Error Occured...");
			}
		
		return null;
		
	}
	
	
	public static  void closeConnection() {
		if(conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
					e.printStackTrace();
			}
	}
	
}

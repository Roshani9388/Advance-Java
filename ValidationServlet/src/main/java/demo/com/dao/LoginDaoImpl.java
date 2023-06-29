package demo.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import demo.com.beans.MyUser;
import demo.com.beans.RegisterUser;

public class LoginDaoImpl implements LoginDao{

	private static Connection conn;
	private static PreparedStatement pck,padduser,paddregisuser; 
	static
	{
		conn=DBUtil.getMyConnection();
		try {
				pck=conn.prepareStatement("select * from user where uname=? and password=?");
				padduser=conn.prepareStatement("insert into user values(?,?,?)");
				paddregisuser=conn.prepareStatement("insert into register values(?,?,?,?,?,?,?,?)");
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	
	@Override
	public MyUser ValidateUser(String uname, String password) {
		try {
			pck.setString(1,uname);
			pck.setString(2,password);
			
			ResultSet rs=pck.executeQuery();
			if(rs.next())
			{
				return new MyUser(uname,password,rs.getString(3));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public int addUser(RegisterUser ru, MyUser user) {
		try {
			
			java.sql.Date dt=java.sql.Date.valueOf(ru.getDt());
			paddregisuser.setInt(1,ru.getUid());
			paddregisuser.setString(2,ru.getName());
			paddregisuser.setString(3,ru.getAddress());
			paddregisuser.setString(4,ru.getUsername());
			paddregisuser.setString(5,ru.getSkills()[0]);
			paddregisuser.setDate(6,dt);
			
			paddregisuser.setString(7,ru.getGender());
			paddregisuser.setString(8,ru.getCity());
			 paddregisuser.executeUpdate();
			
				padduser.setString(1,user.getUname());
				padduser.setString(2,user.getPassword());
				padduser.setString(3,user.getRole());
				return padduser.executeUpdate();
				
		
				
				
				
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return 0;
		
	}

}

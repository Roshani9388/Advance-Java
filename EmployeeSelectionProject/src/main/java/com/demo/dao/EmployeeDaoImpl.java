package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.demo.beans.Employee;
import com.demo.service.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao{
	private static Connection conn;
	private static PreparedStatement padd;
	static
	{
		conn=DBUtil.getMyConnection();
		try {
			padd=conn.prepareStatement("select empno,ename,sal,deptno from emp2 where deptno=?");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public List<Employee> addMore(int deptno) {
		try {
			padd.setInt(1,deptno);
			ResultSet rs=padd.executeQuery();
			List<Employee> elist=new ArrayList<>();
			while(rs.next())
			{
				elist.add(new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4)));
			}
			return elist;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return null;
	}
	@Override
	public void closeConnection() {
		DBUtil.closeMyConnection();
		
	}

}

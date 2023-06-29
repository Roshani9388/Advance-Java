package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.demo.beans.Department;

public class DepartmentDaoImpl implements DepartmentDao {

	private static Connection conn;
	private static PreparedStatement pgetall;
	static {

		conn = DBUtil.getMyConnection();
		try {
			pgetall = conn.prepareStatement("select * from dept");
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public List<Department> displayAllDept() {
		try {
			ResultSet rs=pgetall.executeQuery();
			List<Department> dlist=new ArrayList<>();
			while(rs.next())
			{
				dlist.add(new Department(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			System.out.println(dlist);
			return dlist;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}

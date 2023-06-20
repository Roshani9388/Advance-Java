package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	
	private static Connection con;
	private static PreparedStatement psin,pdisp,ps,pd,pm,psort;
	
	static
	{
		
		try {
			con=DBUtil.getMyConnection();
			psin=con.prepareStatement("insert into CdacEmployee values(?,?,?)");
			pdisp=con.prepareStatement("select * from CdacEmployee");
			pd=con.prepareStatement("delete from CdacEmployee where id=?");
			ps=con.prepareStatement("select * from CdacEmployee where id=?");
			pm=con.prepareStatement("update CdacEmployee set salary=?,ename=? where id=?");
			psort=con.prepareStatement("select * from CdacEmployee order by ename");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	@Override
	public void save(Employee e) {
		try {
			psin.setInt(1,e.getEmpid());
			psin.setString(2,e.getEname());
			psin.setDouble(3, e.getSalary());
			psin.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	
		
	}

	@Override
	public List<Employee> displayAll() {
		List<Employee> emplst=new ArrayList<>();
		ResultSet rs;
		try {
				rs = pdisp.executeQuery();
		
				while(rs.next())
				{
					emplst.add(new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
				}
				return emplst;
			} catch (SQLException e) {
				e.printStackTrace();
				}
			return null;
	}

	@Override
	public void closeConnection() {
		
			DBUtil.closeConnection();
		
		
	}

	@Override
	public List<Employee> sortByName() {
		List<Employee> eset=new ArrayList<>();
		
		try {
			ResultSet rs=psort.executeQuery();
			while(rs.next())
			{
				eset.add(new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3)));
			}
			return eset;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		try {
			pd.setInt(1,id);
			int n=pd.executeUpdate();
			return n>0?true:false;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Employee serchById(int id) {
		try {
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3));
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean modifyRecord(int id, String nm, double sal) {
		try {
			pm.setDouble(1,sal);
			pm.setString(2, nm);
			pm.setDouble(3, id);
			int n=pm.executeUpdate();
			return n>0?true:false;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

}

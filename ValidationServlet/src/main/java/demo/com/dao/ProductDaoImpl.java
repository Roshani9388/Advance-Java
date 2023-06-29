package demo.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import demo.com.beans.Product;

public class ProductDaoImpl implements ProductDao{
	
	private static Connection conn;
	private static PreparedStatement pshow;
	static {
		
		conn=DBUtil.getMyConnection();
		try {
			pshow=conn.prepareStatement("select * from ProductInfo");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> showAll() {
		try {
			ResultSet rs=pshow.executeQuery();
			List<Product> plist=new ArrayList<>();
			while(rs.next())
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4)));
			
			return plist;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}

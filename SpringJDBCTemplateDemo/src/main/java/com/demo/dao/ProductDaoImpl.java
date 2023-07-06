package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void AddProduct(Product p) {
		int n=jdbcTemplate.update("insert into productinfo values(?,?,?,?)",new Object[] {
				p.getPid(),p.getPname(),p.getQty(),p.getPrice()
		});
		
	}

	@Override
	public List<Product> DisplayProd() {
		List<Product> plist=jdbcTemplate.query("select * from productinfo",new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setQty(rs.getInt(3));
				p.setPrice(rs.getFloat(4));
				return p;
			}
			});
		return plist;
	}

	@Override
	public Product serchById(int pid) {
		Product p=jdbcTemplate.queryForObject("select * from productinfo where pid=?",new Object[]
				{pid},BeanPropertyRowMapper.newInstance(Product.class));
		return p;
	}

	@Override
	public boolean modifyById(int pid, String pname) {
		int n=jdbcTemplate.update("update productinfo set pname=? where pid=?",new Object[] {
				pname,pid});
		return n>0;
	}

	@Override
	public boolean deleteById(int pid) {
		int n=jdbcTemplate.update("delete from  productinfo  where pid=?",new Object[] {
				pid});
		return n>0;
		
	}

	@Override
	public List<Product> sortByName() {
		List<Product> plist=jdbcTemplate.query("select * from productinfo order by pname desc",new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product p=new Product();
				p.setPid(rs.getInt(1));
				p.setPname(rs.getString(2));
				p.setQty(rs.getInt(3));
				p.setPrice(rs.getFloat(4));
				return p;
			}
			});
		return plist;
	}

}

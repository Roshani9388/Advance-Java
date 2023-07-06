package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Product> displayAllProduct() {
		
		List<Product> plist=jdbcTemplate.query("select * from productinfo",new RowMapper() {

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
	public Product displayById(int pid) {
		Product p;
		try {
		 p=jdbcTemplate.queryForObject("select * from productinfo where pid=?",new Object[]
				{pid},BeanPropertyRowMapper.newInstance(Product.class));
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
		
		return p;
		
	}

	@Override
	public int deleteById(int pid) {
		int n=jdbcTemplate.update("delete from  productinfo  where pid=?",new Object[] {
				pid});
		return n;
		
	}

	@Override
	public int updateProduct(Product p) {
		int n=jdbcTemplate.update("update productinfo set pname=? where pid=?",new Object[] {
				p.getPname(),p.getPid(),p.getQty(),p.getPrice()});
		return n;
		
	}

	@Override
	public int addNewProd(Product p) {
		int n=jdbcTemplate.update("insert into productinfo values(?,?,?,?)",new Object[] {
				p.getPid(),p.getPname(),p.getQty(),p.getPrice()
		});
		return n;
	}

	
}

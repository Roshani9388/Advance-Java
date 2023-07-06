package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
		@Autowired
		JdbcTemplate jdbcTemplate;
	@Override
	public List<Product> getAllProduct() {
		return jdbcTemplate.query("select * from productinfo", (rs,num)-> {
			Product p=new Product();
			p.setPid(rs.getInt(1));
			p.setPname(rs.getString(2));
			p.setQty(rs.getInt(3));
			p.setPrice(rs.getFloat(4));
			return p;
		});
		
	}
	@Override
	public Product editProd(int pid) {
		
		return jdbcTemplate.queryForObject("select * from productinfo where pid=?",new Object[] 
			{pid},	BeanPropertyRowMapper.newInstance(Product.class)
			);
	}
	@Override
	public void updateProd(Product p) {
			jdbcTemplate.update("update productinfo set pname=?,qty=?,price=? where pid=?",new Object[] 
				{p.getPname(),p.getQty(),p.getPrice(),p.getPid()}
				);
		 }
	@Override
	public void deleteById(int pid) {
		jdbcTemplate.update("delete from productinfo where pid=?",
				new Object[]{pid}
				);
		
	}
	@Override
	public void addProduct(Product p) {
		jdbcTemplate.update("insert into productinfo values(?,?,?,?)",new Object[] {
				p.getPid(),p.getPname(),p.getQty(),p.getPrice()
		});
		
	}
}

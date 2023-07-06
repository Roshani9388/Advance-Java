package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements  ProductService{

	@Autowired
	private ProductDao productDao;
	
	public List<Product> displayAll() {
		return productDao.displayAllProduct();
			
	}

	@Override
	public Product displayById(int pid) {
		
		return productDao.displayById(pid);
	}

	@Override
	public int deleteById(int pid) {
		
		return productDao.deleteById(pid);
	}

	@Override
	public int UpdateProduct(Product p) {
		
		return productDao.updateProduct(p);
	}

	@Override
	public int AddNew(Product p) {
		
		return productDao.addNewProd(p);
	}

	
}

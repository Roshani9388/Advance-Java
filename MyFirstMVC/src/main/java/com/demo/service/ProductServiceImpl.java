package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	@Override
	public List<Product> getAllProduct() {
		
		return productDao.getAllProduct();
	}
	@Override
	public Product editProductById(int pid) {
		
		return productDao.editProd(pid);
	}
	@Override
	public void updateProduct(Product p) {
		
		productDao.updateProd(p);
	}
	@Override
	public void deleteProductById(int pid) {
		productDao.deleteById(pid);
		
	}
	@Override
	public void addNewProduct(Product p) {
		productDao.addProduct(p);
		
	}

}

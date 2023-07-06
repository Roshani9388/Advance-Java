package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> getAllProduct();

	Product editProd(int pid);

	void updateProd(Product p);

	void deleteById(int pid);

	void addProduct(Product p);

}

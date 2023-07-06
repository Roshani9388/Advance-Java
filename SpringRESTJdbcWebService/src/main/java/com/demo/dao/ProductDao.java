package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> displayAllProduct();

	Product displayById(int pid);

	int deleteById(int pid);

	int updateProduct(Product p);

	int addNewProd(Product p);


}

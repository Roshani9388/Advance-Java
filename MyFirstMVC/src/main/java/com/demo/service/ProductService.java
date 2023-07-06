package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllProduct();

	Product editProductById(int pid);

	void updateProduct(Product p);

	void deleteProductById(int pid);

	void addNewProduct(Product p);

}

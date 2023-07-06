package com.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> displayAll();

	Product displayById(int pid);

	int deleteById(int pid);

	int UpdateProduct(Product p);

	int AddNew(Product p);

}

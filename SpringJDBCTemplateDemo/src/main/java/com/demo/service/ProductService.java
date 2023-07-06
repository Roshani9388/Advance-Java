package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void addProduct();

	List<Product> DisplayAll();

	Product searchById(int pid);

	boolean modifyById(int pid, String pname);

	boolean deleteById(int pid);

	List<Product> sortByName();

}

package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void addProduct();

	List<Product> displayAll();

	Product serchById(int pid);

	boolean ModifyById(int pid, String pname, String wname);

	List<Product> sortByName();

	boolean deleteById(int pid);

	void closeMySeesionFactory();

	boolean deleteAll();

}

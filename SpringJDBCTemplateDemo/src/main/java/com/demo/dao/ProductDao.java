package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void AddProduct(Product p);

	List<Product> DisplayProd();

	Product serchById(int pid);

	boolean modifyById(int pid, String pname);

	boolean deleteById(int pid);

	List<Product> sortByName();

}

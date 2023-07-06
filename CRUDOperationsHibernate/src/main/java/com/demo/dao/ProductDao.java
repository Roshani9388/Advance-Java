package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void addProductDetails(Product p);

	List<Product> display();

	Product searchById(int pid);

	boolean ModifyRecord(int pid, String pname, String wname);

	List<Product> sortByName();

	boolean delete(int pid);

	void closeSF();

	boolean deleteAllRecords();

}

package com.demo.service;

import java.util.*;

import com.demo.beans.*;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	
	private ProductDao pdao;
	
	

	public ProductServiceImpl() {
		
		this.pdao = new ProductDaoImpl();
	}

	@Override
	public void addProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Pid");
		int pid=sc.nextInt();
		
		System.out.println("Enter pname");
		String pname=sc.next();
		
		System.out.println("Enter wid");
		int wid=sc.nextInt();
		
		System.out.println("Enter wname");
		String wname=sc.next();
		System.out.println("Enter w location");
		String wloc=sc.next();
		
		Warehouse w=new Warehouse(wid,wname,wloc);
		Product p=new Product(pid,pname,w);
		
		pdao.addProductDetails(p);
		
		
	}

	@Override
	public List<Product> displayAll() {
		
		return pdao.display();
	}

	@Override
	public Product serchById(int pid) {
		
		return pdao.searchById(pid);
	}

	@Override
	public boolean ModifyById(int pid, String pname, String wname) {
	
		return pdao.ModifyRecord(pid,pname,wname);
	}

	@Override
	public List<Product> sortByName() {
		
		return pdao.sortByName();
	}

	@Override
	public boolean deleteById(int pid) {
		
		return pdao.delete(pid);
	}

	@Override
	public void closeMySeesionFactory() {
		pdao.closeSF();
		
	}

	@Override
	public boolean deleteAll() {
		
		return pdao.deleteAllRecords();
	}

}

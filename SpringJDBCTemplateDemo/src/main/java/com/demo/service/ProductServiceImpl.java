package com.demo.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao pdao;
	
	@Override
	public void addProduct() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter pid");
		int pid=sc.nextInt();
		
		System.out.println("Enter pname");
		String pname=sc.next();
		
		System.out.println("Enter quantity");
		int qty=sc.nextInt();
		
		System.out.println("Enter price");
		float price=sc.nextFloat();
		
		Product p=new Product(pid,pname,qty,price);
		
		pdao.AddProduct(p);
	}

	@Override
	public List<Product> DisplayAll() {
		
		return pdao.DisplayProd();
	}

	@Override
	public Product searchById(int pid) {
		
		return pdao.serchById(pid);
	}

	@Override
	public boolean modifyById(int pid, String pname) {
		
		return pdao.modifyById(pid,pname);
	}

	@Override
	public boolean deleteById(int pid) {
		
		return pdao.deleteById(pid);
	}

	@Override
	public List<Product> sortByName() {
		
		return pdao.sortByName();
	}

}

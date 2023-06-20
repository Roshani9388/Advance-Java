package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao  ed;
	

	public EmployeeServiceImpl() {
		super();
		this.ed = new EmployeeDaoImpl();
	}

	@Override
	public void addEmp() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Employee id:");
		int id=sc.nextInt();
		
		System.out.println("Enter Employee name:");
		String nm=sc.next();
		
		System.out.println("Enter Employee salary:");
		double sal=sc.nextDouble();
		
		Employee e=new Employee(id,nm,sal);
		ed.save(e);
		
	
		
		
	}

	@Override
	public List<Employee> displayAll() {
		
		return ed.displayAll();
	}


	@Override
	public List<Employee> sortedbyName() {
		
		return ed.sortByName();
	}

	@Override
	public boolean deleteById(int id) {
		
		return ed.delete(id);
	}

	@Override
	public Employee serchById(int id) {
		
		return ed.serchById(id);
	}

	@Override
	public boolean modify(int id, String nm, double sal) {
		
		return ed.modifyRecord(id,nm,sal);
	}
	

	@Override
	public void closeConnection() {
	ed.closeConnection();
		
	}
	

}

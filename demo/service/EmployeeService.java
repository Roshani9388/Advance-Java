package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeService {

	void addEmp();

	List<Employee> displayAll();

	void closeConnection();

	List<Employee> sortedbyName();

	boolean deleteById(int id);

	Employee serchById(int id);

	boolean modify(int id, String nm, double sal);
}

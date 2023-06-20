package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeDao {

	void save(Employee e);

	List<Employee> displayAll();

	void closeConnection();

	List<Employee> sortByName();

	boolean delete(int id);

	Employee serchById(int id);

	boolean modifyRecord(int id, String nm, double sal);

}

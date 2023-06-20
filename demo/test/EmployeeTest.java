package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Employee;
import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImpl;

public class EmployeeTest {
	public static void main(String ar[])
	{
		int choice=0;
		EmployeeService es=new EmployeeServiceImpl();
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("******** MENU *********");
			System.out.println("1. Add new Employee\n 2. display all\n 3. search by id\n 4. modify salary and name\n 5. Delete employee\n6. sort by name\n7. Exit");
			System.out.println("Enter choice:");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:es.addEmp();
				break;
				
			case 2:
				List<Employee> emlst=es.displayAll();
				emlst.forEach(System.out::println);
				break;
				
			case 3:
				System.out.println("Enter id to search:");
				int id=sc.nextInt();
				Employee e=es.serchById(id);
				System.out.println(e);
				break;
				
			case 4:
				System.out.println("Enter id :");
				 id=sc.nextInt();
				
				System.out.println("Enter name to modify");
				String nm=sc.next();
				
				System.out.println("Enter salary to modify:");
				double sal=sc.nextDouble();
				
				boolean status=es.modify(id,nm,sal);
				if(status)
					System.out.println("Salary and name is modified");
				else
					System.out.println("Not Updated...");
				break;
				
				
			case 5:
				System.out.println("Enter id to delete:");
				 id=sc.nextInt();
				status=es.deleteById(id);
				if(status)
					System.out.println("Deleted...");
				else
					System.out.println("Not deleted...");
				
				break;
				
				
			case 6:
				 emlst=es.sortedbyName();
				emlst.forEach(System.out::println);
				break;
				
			case 7:
				es.closeConnection();
				System.out.println("connection closed...");
				break;
			}
		}while(choice!=7);
	}

}

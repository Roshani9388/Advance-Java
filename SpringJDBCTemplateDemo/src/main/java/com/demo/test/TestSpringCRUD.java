package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Product;
import com.demo.service.ProductService;

public class TestSpringCRUD {

	public static void main(String[] args) {
	ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
	int choice=0;
	Scanner sc=new Scanner(System.in);
	ProductService ps=(ProductService) ctx.getBean("productServiceImpl");
	
	do
	{
		System.out.println("****** Menu ******");
		System.out.println("1. Add Product\n 2. DislapyAll \n 3. SearchById\n 4. ModifyById\n5. Delete by Id\n 6. Sort by name\n 7. Exit. ");
		System.out.println("Enter choice:-");
		choice=sc.nextInt();
		
		switch(choice)
		{
			case 1:
			ps.addProduct();
			break;
			
			case 2:
			List<Product> plist=ps.DisplayAll();
			plist.forEach(System.out::println);
			break;
			
			case 3:
				System.out.println("Enter id to serach product:");
				int pid=sc.nextInt();
				Product p=ps.searchById(pid);
				if(p!=null)
				System.out.println(p);
				else
					System.out.println("Not Found");
				break;
				
			case 4:
				System.out.println("Enter id to modify product:");
				pid=sc.nextInt();
				System.out.println("Enter product name:");
				String pname=sc.next();
				boolean status=ps.modifyById(pid,pname);
				if(status)
				System.out.println("Record updated Successfully......");
				else
					System.out.println("Not Found");
				break;
				
			case 5:
				System.out.println("Enter id to serach product:");
				pid=sc.nextInt();
				status=ps.deleteById(pid);
				if(status)
				System.out.println("Record deleted Successfully.....");
				else
					System.out.println("Not Found");
				break;
				
			case 6:
				 plist=ps.sortByName();
				plist.forEach(System.out::println);
				break;
				
			case 7:
				System.out.println("Thnaks for visiting");
			break;
		}
		
	}while(choice!=7);

	}

}

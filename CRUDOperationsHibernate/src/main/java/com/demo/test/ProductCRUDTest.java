package com.demo.test;
import java.util.*;

import com.demo.beans.Product;
import com.demo.service.*;
public class ProductCRUDTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ProductService ps=new ProductServiceImpl();
		int choice = 0;
		do {
				System.out.println("******** MENU **********");
				System.out.println("1. Add product\n2. Display All\n 3. Search ById\n 4. ModifyById \n 5. Sort Byname\n 6. delete by id\n 7. Delete All \n 8. Exit\n ");
			
				System.out.println("Enter choice:-- ");
				choice=sc.nextInt();
				
				switch(choice)
				{
				case 1:
					ps.addProduct();
					break;
					
				case 2:
					List<Product> plist=ps.displayAll();
					plist.forEach(System.out::println);
					break;
					
				case 3:
					System.out.println("Enter Id to search:-");
					int pid=sc.nextInt();
					
					Product p=ps.serchById(pid);
					if(p!=null)
						System.out.println(p);
					else
						System.out.println("Not Found");
					break;
					
				case 4:
					System.out.println("Enter Id to modify:-");
					 pid=sc.nextInt();
					 
					 System.out.println("Enter Product Name");
					 String pname=sc.next();
					 
					 System.out.println("Enter warehouse Name");
					 String wname=sc.next();
					 
					boolean status=ps.ModifyById(pid,pname,wname);
					if(status)
						System.out.println("Record Updated Successfully...");
					else
						System.out.println("Not Found");
					
					break;
					
				case 5:
					plist =ps.sortByName();
					plist.forEach(System.out::println);
					
					break;
					
				case 6:
					System.out.println("Enter Id to delete:-");
					 pid=sc.nextInt();
					
					status=ps.deleteById(pid);
					if(status)
						System.out.println("Record Updated Successfully...");
					else
						System.out.println("Not Found");
					break;
					
				case 7:
					status=ps.deleteAll();
					if(status)
						System.out.println("Records deleted Successfully...");
					else
						System.out.println("OOOPS Table is Empty");
					break;
					
				case 8:
					System.out.println("Thanks for visiting!!!");
					ps.closeMySeesionFactory();
					sc.close();
					break;
					
					default:
						System.out.println("Invalid choice");
				}
		}while(choice!=8);
	}
	
}

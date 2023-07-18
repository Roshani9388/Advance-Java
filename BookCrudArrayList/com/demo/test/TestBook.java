package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Book;
import com.demo.service.BookService;
import com.demo.service.BookServiceImpl;

public class TestBook {
	
	public static void main(String args[]) {
		
		Scanner sc=new Scanner(System.in);
		int choice=0;
		
		BookService bs=new BookServiceImpl();
		do {
			System.out.println("********* Menu**********");
			System.out.println("1. Add Book to list\n 2. Remove Book from list \n 3. show all books\n 4. Sort byCost\n 5. find by name\n 6. save all book details in file\n 7. Quit");
			
					System.out.println("Enter choice: ");
					choice=sc.nextInt();
					switch(choice) {
					
					case 1:
						bs.addBook();
						break;
						

					case 2:
						System.out.println("Enter book name which u want to remove:");
						String bname=sc.next();
						boolean status=bs.removeBook(bname);
						if(status)
						{
							System.out.println("Book is removed");
						}
						else
							System.out.println("book not found");
						break;

					case 3:
						List<Book> blist=bs.showAllBooks();
						for(Book b:blist)
							System.out.println(b);
						break;

					case 4:
						blist=bs.sortByCost();
						for(Book b:blist)
							System.out.println(b);
						break;

					case 5:
						System.out.println("Enter book name which u want to find:");
						bname=sc.next();
						Book b=bs.findBookByName(bname);
						if(b!=null)
						{
							System.out.println(b);
						}
						else
							System.out.println("book not found");
						
						break;

					case 6:
						status=bs.saveBooksToFile();
						if(status)
						{
							System.out.println("Details are saved to file");
						}
						else
							System.out.println("Error...");
						break;

					case 7:
						System.out.println("Thanks you!!!!");
						sc.close();
						break;
						
						default:
							System.out.println("U entered wrong choice");
						
					}
			
			
		}while(choice!=7);
	}

}

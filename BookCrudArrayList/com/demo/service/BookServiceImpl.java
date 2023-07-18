package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Book;
import com.demo.dao.BookDao;
import com.demo.dao.BookDaoImpl;

public class BookServiceImpl implements BookService{

	private BookDao bdao;
	
	
	
	public BookServiceImpl() {
		super();
		this.bdao = new BookDaoImpl();
	}

	@Override
	public void addBook() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Book name:");
		String bname=sc.next();
		
		System.out.println("Enter Book cost:");
		double bcost=sc.nextDouble();
		
		System.out.println("Enter author name:");
		String aname=sc.next();
		
		Book b=new Book(bname,bcost,aname);
		
		bdao.addBook(b);
		
		
		
		
	}

	@Override
	public boolean removeBook(String bname) {
		
		return bdao.removeBook(bname);
	}

	@Override
	public List<Book> showAllBooks() {
		
		return bdao.showAll();
	}

	@Override
	public List<Book> sortByCost() {
		
		return bdao.sortByCost();
	}

	@Override
	public Book findBookByName(String bname) {
		
		return bdao.findByName(bname);
	}

	@Override
	public boolean saveBooksToFile() {
		
		return bdao.saveToFile();
	}

}

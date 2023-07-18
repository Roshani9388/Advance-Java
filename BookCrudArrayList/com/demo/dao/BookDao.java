package com.demo.dao;

import java.util.List;

import com.demo.beans.Book;

public interface BookDao {

	void addBook(Book b);

	boolean removeBook(String bname);

	List<Book> showAll();

	List<Book> sortByCost();

	Book findByName(String bname);

	boolean saveToFile();

}

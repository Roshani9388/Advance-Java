package com.demo.service;

import java.util.List;

import com.demo.beans.Book;

public interface BookService {

	void addBook();

	boolean removeBook(String bname);

	List<Book> showAllBooks();

	List<Book> sortByCost();

	Book findBookByName(String bname);

	boolean saveBooksToFile();

}

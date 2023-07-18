package com.demo.beans;

public class Book implements Comparable<Book>{
	
	private String bookName;
	private double bookCost;
	private String authorName;
	
	
	public Book() {
		super();
	}


	public Book(String bookName, double bookCost, String authorName) {
		super();
		this.bookName = bookName;
		this.bookCost = bookCost;
		this.authorName = authorName;
	}


	public Book(String bookName, double bookCost) {
		super();
		this.bookName = bookName;
		this.bookCost = bookCost;
	}

	
	
	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public double getBookCost() {
		return bookCost;
	}


	public void setBookCost(double bookCost) {
		this.bookCost = bookCost;
	}


	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", bookCost=" + bookCost + ", authorName=" + authorName + "]";
	}


	@Override
	public int compareTo(Book ob) {
		
		return (int) (this.bookCost-ob.bookCost);
	}
	


}

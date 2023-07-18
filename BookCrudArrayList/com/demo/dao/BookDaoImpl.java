package com.demo.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Book;

public class BookDaoImpl implements BookDao{

	
	private static List<Book> blist;
	static {
		blist=new ArrayList();
	}
	
	@Override
	public void addBook(Book b) {
	
		blist.add(b);
		
	}

	@Override
	public boolean removeBook(String bname) {
		
		boolean res=blist.remove(bname);
		if(res)
		return true;
		
			return false;
	}

	@Override
	public List<Book> showAll() {
	
		return blist;
	}

	@Override
	public List<Book> sortByCost() {
		List<Book> newlist=new ArrayList();
		for(Book ob:blist)
			newlist.add(ob);
		
		newlist.sort(null);
		return newlist;
	}

	@Override
	public Book findByName(String bname) {
		for(Book ob:blist)
		{
			if(ob.getBookName().equals(bname))
				return ob;
		}
		return null;
	}

	@Override
	public boolean saveToFile() {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		int i=0;
		try {
				fis=new FileInputStream("test.txt");
				fos=new FileOutputStream("test1copy.txt");
				
			try {
				i = fis.read();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			while(i!=-1)
			{
				
					try {
						fos.write(i);
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					try {
						i=fis.read();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
			finally {
				try {
					fis.close();
					fos.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			
			}

		return false;
	}
}


package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.demo.beans.*;
public class TestAnnotation {

	public static void main(String[] args) {
	
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session sess=sf.openSession();
			
			Transaction tr=sess.beginTransaction();
			WareHouse w1=new WareHouse(67,"gfhhg","mum");
			Product p1=new Product(78,"Pen",w1);
			System.out.println("before");
			sess.save(p1);
			Product p2=sess.load(Product.class,22);
			System.out.println("after");
			System.out.println(p2);
			
			tr.commit();
			sess.close();
			sf.close();
			
	}

}

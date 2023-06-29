package com.demo.test;
import com.demo.beans.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneToOneWay {

	public static void main(String[] args) {
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Address a=new Address(33,"phule","pune");
		Student s=new Student(88,"roshani",a);
		Transaction tr=sess.beginTransaction();
		
		sess.save(s);
		sess.save(a);
	
		System.out.println(s);
		System.out.println("before");
		Student s1=sess.get(Student.class,12);
		System.out.println("after");
		System.out.println(s1);
		tr.commit();
		sess.close();
		sf.close();
		
	}

}

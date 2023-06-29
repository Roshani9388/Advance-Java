package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.MyUser;

public class TestUserObject {

	public static void main(String[] args) {
		//object is in transient state
		MyUser u1=new MyUser(13,"rosnai","aaaa@jskdf");
		MyUser u2=new MyUser(14,"sfff","aaaa@jskdf");
		//step 1 create session factory object
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		//step2 create session
		Session sess=sf.openSession();
		//sf.getCurrentSession();
		Transaction tr=sess.beginTransaction();
		sess.save(u1);
		sess.save(u2);
		tr.commit();
		sess.close();
		sf.close();
	}
}
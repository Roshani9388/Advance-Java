package com.demo.test;
import com.demo.beans.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Set;
import java.util.HashSet;

public class OneTwoManyMappingTest {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		
		Address a1=new Address(22,"ggg","fgh");
		Address a2=new Address(23,"nagggar","ghgh");
		Set<Address> addrset=new HashSet<>();
		addrset.add(a1);
		addrset.add(a2);
		MyUser m1=new MyUser(78,"rosh",addrset);
		a1.setMu(m1);
		a2.setMu(m1);
		
		sess.save(a1);
		sess.save(a2);
		sess.save(m1);
		MyUser m2=sess.get(MyUser.class,78);
		System.out.println(m2);
		
		tr.commit();
		sess.close();
		sf.close();

	}

}

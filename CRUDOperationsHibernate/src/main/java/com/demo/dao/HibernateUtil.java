package com.demo.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sf;
	
	static SessionFactory openMySessionFactory() {
	
	if(sf==null) {
		
			sf=new Configuration().configure().buildSessionFactory();
	
		}	
	return sf;
	}
	
	static void closeMySessionFactory() {
	
		sf.close();
	}
}

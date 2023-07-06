package com.demo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {

	private static SessionFactory sf;
	static {
		sf=HibernateUtil.openMySessionFactory();
	}
	@Override
	public void addProductDetails(Product p) {
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		s.save(p);
		tr.commit();
		s.close();
		
	}

	@Override
	public List<Product> display() {
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		Query query=s.createQuery("from Product");
		List<Product> plist=query.list();
		tr.commit();
		s.close();
		return plist;
	}

	@Override
	public Product searchById(int pid) {
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		Product p=s.get(Product.class,pid);
		tr.commit();
		s.close();
		return p;
	}

	@Override
	public boolean ModifyRecord(int pid, String pname, String wname) {
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		Product p=s.get(Product.class,pid);
		
		if(p!=null)
		{
			p.setPname(pname);
			p.getW().setWname(wname);
			s.saveOrUpdate(p);
			tr.commit();
			s.close();
			return true;
		}
		return false;
	}

	@Override
	public List<Product> sortByName() {
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		Query query=s.createQuery("from Product p order by p.pname desc");
		List<Product> plist=query.list();
		tr.commit();
		s.close();
		return plist;
	}

	@Override
	public boolean delete(int pid) {
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
		Product p=s.get(Product.class,pid);
		if(p!=null)
		{
			s.delete(p);
			tr.commit();
			s.close();
			return true;
		}
		return false;
	}

	@Override
	public void closeSF() {
		HibernateUtil.closeMySessionFactory();
	}

	@Override
	public boolean deleteAllRecords() {
		Session s=sf.openSession();
		Transaction tr=s.beginTransaction();
	//	String q="delete from Product";
		Query query=s.createQuery("delete from Product");
		query.executeUpdate();
		tr.commit();
		s.close();
		return true;
	}
	

}

package com.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	SessionFactory sessionfactory;

	public List<Product> displayAllProduct() {
		
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		Query query=session.createQuery("from Product p");
		List<Product> plist=query.list();
		tr.commit();
		session.close();
		return plist;
	}

	@Override
	public Product displayById(int pid) {
		
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		Product p=session.get(Product.class,pid);
		tr.commit();
		session.close();
		return p;
		
	}

	@Override
	public int deleteById(int pid) {
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		Product p=session.get(Product.class,pid);
		if(p!=null)
		{
			session.delete(p);
			tr.commit();
			session.close();
			return 1;
		}
		tr.commit();
		session.close();
		return 0;
		
	}

	@Override
	public int updateProduct(Product p) {
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		Product p1=session.get(Product.class,p.getPid());
		if(p1!=null)
		{
			p1.setPname(p.getPname());
			p1.setQty(p.getQty());
			p1.setPrice(p.getPrice());
			session.update(p1);
			tr.commit();
			session.close();
			return 1;
		}
		tr.commit();
		session.close();
		return 0;
	}

	@Override
	public int addNewProd(Product p) {
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(p);
		tr.commit();
		session.close();
		return 1;
	}

	
}

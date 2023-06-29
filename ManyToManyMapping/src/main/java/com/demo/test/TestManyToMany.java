package com.demo.test;
import com.demo.beans.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Set;
import java.util.HashSet;


public class TestManyToMany {

	public static void main(String[] args) {
		
		SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		
		/*
		 * Employee e1=new Employee(1,"rosh",null); Employee e2=new
		 * Employee(2,"shailu",null); Employee e3=new Employee(3,"shrey",null); Employee
		 * e4=new Employee(4,"sangu",null);
		 * 
		 * Set<Employee> eset1=new HashSet<>(); eset1.add(e1); eset1.add(e2);
		 * Set<Employee> eset2=new HashSet<>(); eset2.add(e3); eset2.add(e4);
		 * 
		 * Projects p1=new Projects(11,"java",2,eset1); Projects p2=new
		 * Projects(21,"java",3,eset1); Projects p3=new Projects(31,"java",1,eset2);
		 * Projects p4=new Projects(41,"java",6,eset2);
		 * 
		 * Set<Projects> pset1=new HashSet<>(); pset1.add(p1); pset1.add(p2);
		 * Set<Projects> pset2=new HashSet<>(); pset2.add(p3); pset2.add(p4);
		 * 
		 * e1.setPset(pset1); e2.setPset(pset1);
		 * 
		 * e3.setPset(pset2); e4.setPset(pset2);
		 * 
		 * sess.save(e1); sess.save(e2); sess.save(e3); sess.save(e4);
		 * 
		 * sess.save(p1); sess.save(p2); sess.save(p3); sess.save(p4);
		 * 
		 * tr.commit(); sess.close(); sf.close();
		 */

		Projects p1=new Projects(112,"proj1",4,null);
		Projects p2=new Projects(113,"proj2",3,null);
		Projects p3=new Projects(114,"proj3",4,null);
		Set<Projects> sp1=new HashSet<>();
		sp1.add(p1);
		sp1.add(p2);
		Set<Projects> sp2=new HashSet<>();
		sp2.add(p1);
		sp2.add(p3);
		Employee e1=new Employee(221,"Rajan",sp1);
		Employee e2=new Employee(222,"Revati",sp1);
		Employee e3=new Employee(223,"Anil",sp2);
		Set<Employee> se1=new HashSet<>();
		se1.add(e1);
		se1.add(e2);
		Set<Employee> se2=new HashSet<>();
		se2.add(e3);
		p1.setEset(se1);
		p2.setEset(se2);
		sess.save(e1);
		sess.save(e2);
		sess.save(e3);
		sess.save(p1);
		sess.save(p2);
		sess.save(p3);
		
		Employee e=sess.get(Employee.class,222);
		System.out.println(e);
		Projects p=sess.get(Projects.class,112);
		System.out.println(p);
		tr.commit();
		sess.close();
		sf.close();
		
	}

}

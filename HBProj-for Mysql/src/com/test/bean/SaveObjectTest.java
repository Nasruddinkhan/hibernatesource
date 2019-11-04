package com.test.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.domain.EmpDetails;

public class SaveObjectTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		EmpDetails details=null;
		int idVal=0;
		//Activate HB framework
		cfg=new Configuration();
		//read both HB cfg , mapping files
		cfg=cfg.configure("/com/cfgs/hibernate.cfg.xml");
		//build SessionFactory
		factory=cfg.buildSessionFactory();
		// build SEssion
		ses=factory.openSession();
		//prepare Obj for Domain class having data
		details=new EmpDetails();
		details.setNo(1017); details.setFname("nasruddin");
		details.setLname("khan"); details.setMail("nasru@x.com");
		   try{
	      tx=ses.beginTransaction();
	       idVal=(Integer)ses.save(details);
	       System.out.println("Generated id value : "+idVal);

	       tx.commit();
	       System.out.println(details);
	    }
		   
	    catch(Exception e){
	    	e.printStackTrace();
	    	tx.rollback();
	    }
		//save obj using ses.persist(-)
		/*try{
			tx=ses.beginTransaction();
			ses.persist(details);
			tx.commit();
		}
		catch(Exception e){
			tx.rollback();
		}*/
		System.out.println("Object is saved/Record is inserted"); 
		//close Session
		ses.close();
		//close SessionFactory
		factory.close(); 
	}//main
}//class

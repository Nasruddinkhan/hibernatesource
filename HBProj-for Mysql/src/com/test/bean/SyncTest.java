package com.test.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.domain.EmpDetails;

public class SyncTest {
	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Transaction tx=null;
		EmpDetails details=null;
		//Activate HB F/w
		cfg=new Configuration();
		//read both xml files
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//Build SessionFactory
		factory=cfg.buildSessionFactory();
		//open session
		ses=factory.openSession();

		/*	// Show Sync b/w obj to db table row
		details=(EmpDetails)ses.get(EmpDetails.class,1008);
		try{
		 tx=ses.beginTransaction();
		   details.setMail("111@222.com");
		 tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
		}*/
		//show Sync b/w Db table row to obj
		details=(EmpDetails)ses.get(EmpDetails.class,1008);
		System.out.println(details);
		try{
			Thread.sleep(40000); //modify 1008 record in Db table
		}
		catch(Exception e){

		}
		ses.refresh(details);
		System.out.println(details);


		//close Session
		ses.close();
		//close SessionFactory
		factory.close();


	}

}

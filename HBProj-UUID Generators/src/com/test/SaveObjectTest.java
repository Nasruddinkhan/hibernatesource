package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.domain.EmpDetails;
import com.test.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args)throws Exception {
		Session ses=null;
		EmpDetails details=null;
		String id=null;
	   // get Sessoin
		ses=HibernateUtil.getSession();
	   //save obj
		details=new EmpDetails();
		details.setFname("nasru");
		details.setLname("khan");
		details.setMail("nasru@1237.com");
		Transaction tx=null;
		
		try{
		 tx=ses.beginTransaction();
		  id=(String)ses.save(details);
		 System.out.println("Generated id value::"+id);
		tx.commit();
      }//try
	  catch(Exception e){
		  tx.rollback();
	  }
		
	  //close Session
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class

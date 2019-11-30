package com.mypractice.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.EmpDetails;
import com.mypractice.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args)throws Exception {
		Session ses=null;
		EmpDetails details=null;
		int id=0;
	   // get Sessoin
		ses=HibernateUtil.getSession();
	   //save obj
		details=new EmpDetails();
		//details.setNo(9002);
		details.setFname("nasru");
		details.setLname("khan");
		details.setMail("nasru@gmail.com");
		Transaction tx=null;
		
		try{
		 tx=ses.beginTransaction();
		  id=(int)ses.save(details);
		 System.out.println("Generated id value::"+id);
		tx.commit();
      }//try
	  catch(Exception e){
		  e.printStackTrace();
		  tx.rollback();
	  }
		
	  //close Session
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class

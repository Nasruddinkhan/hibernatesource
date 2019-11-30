package com.mypractice.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.EmpDetails;
import com.mypractice.utility.HibernateUtil;

public class SaveObjectTest {

	public static void main(String[] args)throws Exception {
		Session ses=null;
		EmpDetails details=null;
		String id=null;
	   // get Sessoin
		ses=HibernateUtil.getSession();
	   //save obj
		details=new EmpDetails();
		//details.setNo(9002);
		details.setFname("nasuddin");
		details.setLname("khan");
		details.setMail("nasruddinkhan@gmail.com");
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

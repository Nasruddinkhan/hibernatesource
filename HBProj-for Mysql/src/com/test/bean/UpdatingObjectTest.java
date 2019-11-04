package com.test.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.domain.EmpDetails;

public class UpdatingObjectTest {
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
	//Approach1: Update obj directly using ses.update(-)
	  /* details=new EmpDetails();
	   details.setNo(1016); 
	   details.setFname("Jalalluddin Gayasuddin");
	   details.setLname("khan"); 
	   details.setMail("Jkhan@gmail.com"); */
	  /* try{
		 tx=ses.beginTransaction();
		    ses.update(details);
		 tx.commit();
	   }
	   catch(Exception e){
		   tx.rollback();
	   }*/
	  //Approch2: Load and update obj
	  //load obj
	   details=(EmpDetails)ses.get(EmpDetails.class,1016);
	   if(details==null){
		   System.out.println("Obj/record not found to update");
	   }
	   else{
		   try{
			   tx=ses.beginTransaction();
			   details.setMail("xuz1@adda.com");
			   ses.update(details);
			   tx.commit();
		   }
		   catch(Exception e){
			   tx.rollback();
		   }

	   }
	   //close session
	   ses.close();
	   //clsoe SessionFatory
	   factory.close();
		
	}
	

}

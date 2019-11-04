package com.test.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.domain.EmpDetails;

public class DeleteObjecTest {

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
 //Approach1: directly deleting the record using ses.delete(-)
	   details=new EmpDetails();
	   details.setNo(1001);
	   try{
	     tx=ses.beginTransaction();
	       ses.delete(details);
	     tx.commit();
	   }//try
	   catch(Exception e){
		   tx.rollback();
	   }
   //Approach2: load and delete the obj/record
	    //load obj/record
	   details=(EmpDetails)ses.get(EmpDetails.class,1004);
	   if(details==null){
		   System.out.println("Record/obj not found to delete");
	   }
	   else{
		 try{
		 tx=ses.beginTransaction();
		    ses.delete(details);
		 tx.commit();
		 }//try
		 catch(Exception e){
			 tx.rollback();
		 }
		 System.out.println("Record/obj found and deleted");  
	   }//else
	   
	   //close session obk
	   ses.close();
	   //close SessionFactory obj
	   factory.close();
	}//main
}//class

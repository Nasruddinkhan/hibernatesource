package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.test.domain.EmpDetails;

public class LoadObjectTest {
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
	cfg=cfg.configure("/com/test/cfgs/hibernate.cfg.xml");
   
	//build SessionFactory
	factory=cfg.buildSessionFactory();
	// build SEssion
   ses=factory.openSession();
 
   //load obj/load record
   details=(EmpDetails)ses.get(EmpDetails.class, 2001);
     if(details!=null){
    	//System.out.println(details);
    }
    else{
    	System.out.println("Record not found");
    }
   //load obj using ses.load(-,-)
   //details=(EmpDetails)ses.load(EmpDetails.class, 1001);
    //System.out.println(details);
  
    //close session
    ses.close();
    factory.close();
	}//main
}//class

package com.test.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.domain.EmpDetails;
import com.test.utility.HibernateUtil;

public class EmpDAOImpl implements EmpDAO {

	@Override
	public void insertEmpData(){
      Session ses=null;
      EmpDetails details=null;
      Transaction tx=null;
      //create obj for domain class
      details=new EmpDetails();
      details.setNo(1001);
      details.setFname("raja");
      details.setLname("chari");
      details.setMail("chari@xyz.com");
      //get Session
      ses=HibernateUtil.getSession();
      try{
    	tx=ses.beginTransaction();
    	  ses.save(details);
    	tx.commit();
    	System.out.println("Object saved");
      }//try
      catch(Exception e){
    	tx.rollback();
      }
     }//method

	@Override
	public void loadAndModify() {
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;
		// get Session
		ses=HibernateUtil.getSession();
	  //Load obj/record
		details=(EmpDetails)ses.get(EmpDetails.class,1001);
		//modify obj
		try{
		  tx=ses.beginTransaction();
		    details.setMail("raja1@king1.com");
		  tx.commit();
		  System.out.println("object modified for"+details.getVer()+"times");
		}
		catch(Exception e){
			tx.rollback();
		}
	}
  }//class


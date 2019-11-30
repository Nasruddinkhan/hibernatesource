package com.mypractice.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.EmpDetails;
import com.mypractice.utility.HibernateUtil;

public class NamedHQLTest {

	public static void main(String[] args) {
		Session ses=null;
		// Get Session
		 ses=HibernateUtil.getSession();
		
		   // Access named Query
		    Query query=ses.getNamedQuery("HQL_GET_EMP_DETAILS_BY_EMAIL");
		    //set param values
		    query.setInteger("start",100);
		   query.setInteger("end",200);
		   //execute the Query
		    List<EmpDetails> list=query.list();
		    //process the results
		     for(EmpDetails ed:list){
		         System.out.println(ed);
		      }
		 //Access Named Query
		  query=ses.getNamedQuery("HQL_UPDATE_EMAIL_BY_NO");
		 //set param values
		 query.setInteger("oldNo",101);
		 query.setString("newMail","nasru@yahoo.com");
		 Transaction tx=null;
		 try{
		  tx=ses.beginTransaction();
		    int result=query.executeUpdate();
		  tx.commit();
		  if(result==0)
			  System.out.println("record not found");
		  else
			  System.out.println("Record updated");
		 }//try
		 catch(Exception e){
			 tx.rollback();
		 }
		 
		 
				 
       //close objs
	HibernateUtil.closeSession();
	HibernateUtil.closeSessionFactory();
		     

	}

}

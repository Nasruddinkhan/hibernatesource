package com.test.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.domain.EmpDetails;
import com.test.utility.MySqlHibernateUtil;
import com.test.utility.OracleHibernateUtil;

public class TransferDAOImpl implements TransferDAO {

	@Override
	public boolean transferEmployee(int eid) {
		Session oraSes=null,mysqlSes=null;
		EmpDetails details=null;
		Transaction tx=null; 
		boolean flag=false;
		//get Oracle Session
		oraSes=OracleHibernateUtil.getSession();
		//Load obj from Oracle
		details=(EmpDetails)oraSes.get(EmpDetails.class,eid);
		//save obj into mysql
		    // get MySql session
		   mysqlSes=MySqlHibernateUtil.getSession();
		     // save obj
		   try{
		    tx=mysqlSes.beginTransaction();
		    System.out.println("details ["+details+"]");
		       mysqlSes.save(details);
		    tx.commit();
		    flag=true;
		   }//try
		   catch(Exception e){
			   e.printStackTrace();
			   tx.rollback();
			   flag=false;
		   }
		   OracleHibernateUtil.closeSession();
		   MySqlHibernateUtil.closeSession();
		      
		return flag;
	}//method
}//class


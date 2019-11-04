package com.test.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.domain.EmpDetails;
import com.test.utility.HibernateUtil;

public class EmpDAOImpl implements EmpDAO {

	@Override
	public boolean insertEmpData(int no, String fname, String lname, String mail) {
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//create obj for domain class
		details=new EmpDetails();
		details.setNo(no); details.setFname(fname);
		details.setLname(lname); details.setMail(mail);
		
		try{
		 tx=ses.beginTransaction();
		  ses.save(details);
		 tx.commit();
		  return true;
		}
		catch(Exception e){
	    	return false;
		}//catch
	}//insertEmpData

	@Override
	public EmpDetails retriveEmpData(int no) {
		Session ses=null;
		EmpDetails details=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load obj/record
		details=ses.get(EmpDetails.class,no);
		return details;
	}

	@Override
	public boolean modifyEmpDetails(int no, String newEmail) {
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load obj/record
		details=retriveEmpData(no);
		//modify obj/record
		if(details!=null){
		try{
		  tx=ses.beginTransaction();
			 details.setMail(newEmail);
		   tx.commit();
		   return true;
		}//try
		catch(Exception e){
			return false;
		}
	   }
      else{
		 return false;
		}
	}//method

	@Override
	public boolean deleteEmpDetails(int no) {
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;
		// get Sesion obj
		ses=HibernateUtil.getSession();
		//Load obj/record
		details=retriveEmpData(no);
		if(details!=null){
			try{
			 tx=ses.beginTransaction();
			  ses.delete(details);
			 tx.commit();
			 return true;
			}//try
			catch(Exception e){
				tx.rollback();
				return false;
			}
		}//if
		else{
		 return false;
		}
	}//method

}//class


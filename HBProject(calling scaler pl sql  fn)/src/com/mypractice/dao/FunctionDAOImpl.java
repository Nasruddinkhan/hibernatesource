package com.mypractice.dao;

import java.sql.CallableStatement;
import java.sql.Types;

import org.hibernate.Session;

import com.mypractice.utility.HibernateUtil;

public class FunctionDAOImpl implements FunctionDAO {
 @Override
public void getEmpDetailsByFirstNameByID(Integer eID) {
	 Session ses=null;
	// Query query=null;
	 //List<EmpDetails>list=null;
    //Get Session 
	 ses=HibernateUtil.getSession();
	//get Access to NamedNativeSQL Query
	 //query=ses.getNamedQuery("EMP_DETAILS");
	 //set param value
	
    
    String name  =ses.doReturningWork(con->{
    	try (CallableStatement function = con
    	        .prepareCall(
    	            "{ ? = call EMP_DETAILS_BY_INITCHARS(?) }")) {
    	        function.registerOutParameter(1, Types.VARCHAR);
    	        function.setInt(2, eID);
    	        function.execute();
    	        return function.getString(1);
    	    }
    });
	System.out.println("nmae "+name);

 }//method 
}//class


package com.mypractice.test;

import com.mypractice.dao.FunctionDAO;
import com.mypractice.dao.FunctionDAOFactory;
import com.mypractice.utility.HibernateUtil;

public class FunctionTest {

	public static void main(String[] args) {
		FunctionDAO dao=null;
	   //Get DAO
	   dao=FunctionDAOFactory.getInstance();
	   //call method
	   dao.getEmpDetailsByFirstNameByID(2000);
	   
	   //close objs
	   HibernateUtil.closeSession();
	   HibernateUtil.closeSessionFactory();
		

	}

}

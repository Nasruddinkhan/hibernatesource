package com.mypractice.test;

import com.mypractice.dao.OToODAO;
import com.mypractice.dao.OToODAOFactory;
import com.mypractice.utility.HibernateUtil;

public class ClientApp {

	public static void main(String[] args) {
     OToODAO dao=null;		
		//get DAO
	 dao=OToODAOFactory.getInstance();
	   dao.saveDataUsingStudent();
	   //dao.saveDataUsingLibraryMembership();
	 //dao.loadDataUsingStudent();
	 dao.loadDataUsingLibraryMembership();
	 //close objs
	   HibernateUtil.closeSession();
	   HibernateUtil.closeSessionFactory();
	}
}

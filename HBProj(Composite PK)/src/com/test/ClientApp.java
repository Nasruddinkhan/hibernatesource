package com.test;

import com.test.dao.Proj_PrgmrDAO;
import com.test.dao.Proj_PrgmrDAOFactory;
import com.test.utility.HibernateUtil;

public class ClientApp {
	
	public static void main(String[] args) {
		Proj_PrgmrDAO dao=null;
		// get DAO
		dao=Proj_PrgmrDAOFactory.getInstance();
		//save data
		 //dao.saveData();
		//Load data
		dao.loadData();
		
		//close Session
		HibernateUtil.closeSession();
		//close SEssionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class

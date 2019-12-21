package com.mypractice.test;

import com.mypractice.dao.InheritanceDAO;
import com.mypractice.dao.InheritanceDAOFactory;
import com.mypractice.utility.HibernateUtil;

public class InheritanceMappingTest {

	public static void main(String[] args) {
		InheritanceDAO dao=null;
		//get DAO
		dao=InheritanceDAOFactory.getInstance();
		System.out.println("-----save data-----");
		dao.saveData();
		
	//	System.out.println("-----Display data------");
	//	dao.retrieveData();
		
		
		//close Objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class


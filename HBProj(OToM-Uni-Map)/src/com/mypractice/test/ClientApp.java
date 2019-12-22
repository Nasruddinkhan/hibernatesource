package com.mypractice.test;

import com.mypractice.dao.OToMDAO;
import com.mypractice.dao.OToMDAOFactory;
import com.mypractice.utility.HibernateUtil;

public class ClientApp {
	public static void main(String[] args) {
		OToMDAO dao = null;
		// get DAO
		dao = OToMDAOFactory.getInstance();
		 dao.saveData();
		 //dao.deleteAChildFromParent();
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class

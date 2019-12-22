package com.mypractice.test;

import com.mypractice.dao.OToMDAO;
import com.mypractice.dao.OToMDAOFactory;
import com.mypractice.utility.HibernateUtil;

public class ClientApp {

	public static void main(String[] args) {
		OToMDAO dao=null;
		//get DAO
		dao=OToMDAOFactory.getInstance();
		dao.saveDataUsingUser();
		dao.saveDataUsingPhoneNumber();
		dao.loadDataUsingUser();
		//dao.loadDataUsingPhoneNumber();
		//dao.deleteUsingUser();
		//dao.deleteUsingPhoneNumber();
		//dao.listDataUsingJoinsAndPhoneNumber();
		//dao.listDataUisngFetchJoinAndUser();
		 //dao.loadDataUsingQBC();
		// close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}

}

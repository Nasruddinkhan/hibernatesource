package com.mypractice.test;

import com.mypractice.dao.OToMDAO;
import com.mypractice.dao.OToMDAOFactory;
import com.mypractice.utility.HibernateUtil;

public class ClientApp {
	public static void main(String[] args) {
		OToMDAO dao = null;
		// get DAO
		dao = OToMDAOFactory.getInstance();
		//save data
		dao.saveData();
		dao.loadData();
		dao.deleteOneChildOfAParent();
		dao.deleteAllChildsOfParent();
		dao.addChildToExistingParent();
		dao.deleteParentAnditsChilds();
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class

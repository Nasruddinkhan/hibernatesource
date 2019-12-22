package com.mypractice.test;

import com.mypractice.dao.MToODAO;
import com.mypractice.dao.MToODAOFactory;
import com.mypractice.utility.HibernateUtil;

public class ClientApp {

	public static void main(String[] args)throws Exception {
		MToODAO dao=null;
		//get DAO
		dao=MToODAOFactory.getInstance();
		dao.saveChildsWithParent();
		dao.loadChildsAndTheirParent();
		dao.addEmployeeToExistingDept();
		dao.addExistingEmployeeToNewDept();
		dao.deletingAllEmployeesWithDept();
		dao.deleteEmployeeFromDept();
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class


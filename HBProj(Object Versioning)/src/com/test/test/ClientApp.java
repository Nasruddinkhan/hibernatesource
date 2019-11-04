package com.test.test;

import com.test.dao.EmpDAO;
import com.test.dao.EmpDAOFactory;
import com.test.utility.HibernateUtil;

public class ClientApp {

	public static void main(String[] args) {
		EmpDAO dao=null;
		//get DAO
		 dao=EmpDAOFactory.getInstance();
		 //use Dao
		 //dao.insertEmpData();
		 dao.loadAndModify();
        //Close Session
         HibernateUtil.closeSession();
         //Close SessionFactory
         HibernateUtil.closeSessionFactory();
	}//main
}//class


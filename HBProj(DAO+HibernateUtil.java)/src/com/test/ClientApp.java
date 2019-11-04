package com.test;

import com.test.dao.EmpDAO;
import com.test.dao.EmpDAOFactory;
import com.test.utility.HibernateUtil;

public class ClientApp {

	public static void main(String[] args) {
		EmpDAO dao=null;
		//get DAO
		 dao=EmpDAOFactory.getInstance();
		//call persistence methods
		 /*System.out.println("Emp Registered?:::"+dao.insertEmpData(3001,"raja","chari","raja@chari.com"));
         System.out.println("3001 Emp Details are"+dao.retriveEmpData(3001));
         System.out.println("Modify Email"+dao.modifyEmpDetails(3001,"chari@xyz.com"));
         System.out.println("3001 Emp Details are"+dao.retriveEmpData(3001));
         */
		 System.out.println("Delete 3001 Emp Details"+dao.deleteEmpDetails(3001));
        //Close Session
         HibernateUtil.closeSession();
         //Close SessionFactory
         HibernateUtil.closeSessionFactory();
	}//main
}//class


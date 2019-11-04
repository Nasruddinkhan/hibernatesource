package com.test;

import com.test.dao.TransferDAO;
import com.test.dao.TransferDAOFactory;
import com.test.utility.MySqlHibernateUtil;
import com.test.utility.OracleHibernateUtil;

public class TransferTest {

	public static void main(String[] args) {
		TransferDAO dao=null;
		// get DAO
		dao=TransferDAOFactory.getInstance();
		//use DAO
		System.out.println("Emp Transfered?"+dao.transferEmployee(1017));
         //close Session Factory
		OracleHibernateUtil.closeSessionFactory();
		MySqlHibernateUtil.closeSessionFactory();
	}//main
}//class

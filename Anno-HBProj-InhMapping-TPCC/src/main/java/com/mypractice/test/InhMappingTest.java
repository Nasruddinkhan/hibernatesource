package com.mypractice.test;

import com.mypractice.dao.PaymentDAO;
import com.mypractice.dao.PaymentDAOFactory;
import com.mypractice.utility.HibernateUtil;

public class InhMappingTest {

	public static void main(String[] args) {
		//get DAO
		PaymentDAO dao=PaymentDAOFactory.getInstance();
		//save data
		dao.saveData();
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class

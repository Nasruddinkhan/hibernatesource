package com.mypractice.utility;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.EmployeeHLO;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 2003; i < 3000; i++) {
			Session session = HibernateUtil.getSession();
			EmployeeHLO employeeHLO = new EmployeeHLO();
			employeeHLO.setEid(i);
			employeeHLO.setEmail("nasruddin"+i+"@gmail.com");
			employeeHLO.setLastName("khan");
			employeeHLO.setFirstName("nasruddin"+i);

			Transaction tx = session.beginTransaction();
			session.save(employeeHLO);
			tx.commit();
			HibernateUtil.closeSession();
		}
	}

}

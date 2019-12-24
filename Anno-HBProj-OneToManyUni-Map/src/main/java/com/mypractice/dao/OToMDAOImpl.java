package com.mypractice.dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.PhoneNumber;
import com.mypractice.domain.User;
import com.mypractice.utility.HibernateUtil;

public class OToMDAOImpl implements OToMDAO {

	@Override
	public void saveDataUsingUser() {
		Session ses = null;
		User user = null;
		PhoneNumber ph1 = null, ph2 = null;
		Transaction tx = null;
		Map<String,PhoneNumber> map = null;
		// Get Session
		ses = HibernateUtil.getSession();
		// save objs
		user = new User();
		user.setUserId(2222);
		user.setFirstName("nasru");
		// create child objs
		ph1 = new PhoneNumber();
		ph1.setPhone(9999999);
		ph1.setNumberType("office");

		ph2 = new PhoneNumber();
		ph2.setPhone(8888888);
		ph2.setNumberType("residence");
		// prepare Set Collection
		map = new HashMap<String,PhoneNumber>();
		map.put("airtel",ph1);
		map.put("vodafone",ph2);
		// add multiple childs to parent
		user.setPhones(map);
		try {
			tx = ses.beginTransaction();
			ses.save(user);
			tx.commit();
			System.out.println("objects are saved");
		} // try
		catch (Exception e) {
			tx.rollback();
		}

	}// method

}// class

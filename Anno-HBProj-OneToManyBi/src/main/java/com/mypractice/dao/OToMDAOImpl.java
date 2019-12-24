package com.mypractice.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.PhoneNumber;
import com.mypractice.domain.User;
import com.mypractice.utility.HibernateUtil;

public class OToMDAOImpl implements OToMDAO {

	public void saveDataUsingUser() {
		Session ses = null;
		User user = null;
		PhoneNumber ph1 = null, ph2 = null;
		Transaction tx = null;
		Set<PhoneNumber> phonesSet = null;
		// Get Session
		ses = HibernateUtil.getSession();
		// save objs
		user = new User();
		user.setUserId(3333);
		user.setFirstName("nasru");
		// create child objs
		ph1 = new PhoneNumber();
		ph1.setPhone(9999999);
		ph1.setNumberType("office");

		ph2 = new PhoneNumber();
		ph2.setPhone(8888888);
		ph2.setNumberType("residence");
		//add parent to childs
		ph1.setUser(user);
		ph2.setUser(user);
		// prepare Set Collection
		phonesSet = new HashSet<PhoneNumber>();
		phonesSet.add(ph1);
		phonesSet.add(ph2);
		// add multiple childs to parent
		user.setPhones(phonesSet);
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
	
	@Override
	public void saveDataUsingPhoneNumber() {
		Session ses = null;
		User user = null;
		PhoneNumber ph1 = null, ph2 = null;
		Transaction tx = null;
		Set<PhoneNumber> phonesSet = null;
		// Get Session
		ses = HibernateUtil.getSession();
		// save objs
		user = new User();
		user.setUserId(1002);
		user.setFirstName("ravi");
		// create child objs
		ph1 = new PhoneNumber();
		ph1.setPhone(66666666);
		ph1.setNumberType("office");

		ph2 = new PhoneNumber();
		ph2.setPhone(77777777);
		ph2.setNumberType("residence");
		//add parent to childs
		ph1.setUser(user);
		ph2.setUser(user);
		// prepare Set Collection
		phonesSet = new HashSet<PhoneNumber>();
		phonesSet.add(ph1);
		phonesSet.add(ph2);
		// add multiple childs to parent
		user.setPhones(phonesSet);
		try {
			tx = ses.beginTransaction();
			  ses.save(ph1);ses.save(ph2);
			tx.commit();
			System.out.println("objects are saved");
		} // try
		catch (Exception e) {
			tx.rollback();
		}
	}//method

	
}// class

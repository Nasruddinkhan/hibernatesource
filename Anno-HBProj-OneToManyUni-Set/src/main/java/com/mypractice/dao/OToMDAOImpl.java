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

	@Override
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
		user.setUserId(1001);
		user.setFirstName("nasru");
		// create child objs
		ph1 = new PhoneNumber();
		ph1.setPhone(9999999);
		ph1.setNumberType("office");

		ph2 = new PhoneNumber();
		ph2.setPhone(8888888);
		ph2.setNumberType("residence");
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
	public void loadDataUsingUser() {
		Session ses = null;
		Set<PhoneNumber> childs = null;
		Query query = null;
		List<User> list = null;
		// getSession
		ses = HibernateUtil.getSession();
		// load objs(parent to child)
		query = ses.createQuery("from User");
		list = query.list();
		for (User user : list) {
			System.out.println("parent::::" + user);
			childs = user.getPhones();
			for (PhoneNumber ph : childs) {
				System.out.println("child::::" + ph);
			} // for
		} // for
	}// method

	@Override
	public void loadDataUsingUserWithQBC() {
		Session ses = null;
		Set<PhoneNumber> childs = null;
		Criteria criteria = null;
		List<User> list = null;
		// getSession
		ses = HibernateUtil.getSession();
		// use QBC
		criteria = ses.createCriteria(User.class);
		list = criteria.list();
		for (User user : list) {
			System.out.println("parent::::" + user);
			childs = user.getPhones();
			for (PhoneNumber ph : childs) {
				System.out.println("child::::" + ph);
			} // for
		} // for
	}// method
	
	@Override
	public void deleteOnlyPhonesOfAUser() {
		Session ses = null;
		Criteria criteria = null;
		Set<PhoneNumber> childs = null;
		User user=null;
		Transaction tx=null;
		// getSession
		ses = HibernateUtil.getSession();
		//load parent
		user=ses.get(User.class,1001);
		//load child objs
		childs=user.getPhones();
		//delte childs
		try{
		tx=ses.beginTransaction();
		  childs.removeAll(childs);
		 tx.commit();
		 System.out.println("All chidls are removed");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
}// class

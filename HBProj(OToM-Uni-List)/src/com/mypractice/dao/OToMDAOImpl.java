package com.mypractice.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.PhoneNumber;
import com.mypractice.domain.User;
import com.mypractice.utility.HibernateUtil;

public class OToMDAOImpl implements OToMDAO {

	@Override
	public void saveData() {
		Session ses = null;
		User user = null;
		PhoneNumber ph1 = null, ph2 = null;
		Transaction tx = null;
		List<PhoneNumber> phonesList = null;
		// Get Session
		ses = HibernateUtil.getSession();
		// save objs
		user = new User();
		user.setUserId(1001);
		user.setFirstName("nasruddin");
		// create child objs
		ph1 = new PhoneNumber();
		ph1.setPhone(9999999);
		ph1.setNumberType("office");

		ph2 = new PhoneNumber();
		ph2.setPhone(8888888);
		ph2.setNumberType("residence");
		// prepare Set Collection
		phonesList = new ArrayList<PhoneNumber>();
		phonesList.add(ph1);
		phonesList.add(ph2);
		// add multiple childs to parent
		user.setPhones(phonesList);
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
	public void deleteAChildFromParent() {
		Session ses = null;
		User user = null;
		Transaction tx = null;
		List<PhoneNumber> childs = null;
		PhoneNumber ph1=null;
		// Get Session
		ses = HibernateUtil.getSession();
		//Load parent obj
		user=(User)ses.get(User.class,1001);
		//Load all childs of parent
		childs=user.getPhones();
		//remove one child  from collection
		try{
		 tx=ses.beginTransaction();
		   childs.remove(0);
		  tx.commit();
		  System.out.println("child is removed");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method

		
}// class

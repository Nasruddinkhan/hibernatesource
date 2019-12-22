package com.mypractice.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
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
		Set<PhoneNumber> phonesSet = null;
		// Get Session
		ses = HibernateUtil.getSession();
		// save objs
		user = new User();
		user.setUserId(1001);
		user.setFirstName("naru");
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
	public void loadData() {
		Session ses = null;
		Set<PhoneNumber> childs = null;
		Query query=null;
		List<User> list=null;
		// getSession
		ses = HibernateUtil.getSession();
		// load objs(parent to child)
		query=ses.createQuery("from User");
		list=query.list();
		for(User user:list){
		  System.out.println("parent::::"+user);
		 childs=user.getPhones();
		 System.out.println("hello1");
		 childs.toString();
		
		}//for
	}//method
	@Override
	public void deleteOneChildOfAParent() {
		Session ses=null;
		User user=null;
		Set<PhoneNumber> childs=null;
		PhoneNumber phone=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load parent
		user=(User)ses.get(User.class,1001);
		//load all childs
		childs=user.getPhones();
		//load the child from DB s/w that u want to delete
		phone=(PhoneNumber)ses.get(PhoneNumber.class,(long)8888888);
		//Delete the above PhoneNumber obj from collection
		 try{
			tx=ses.beginTransaction();
			 childs.remove(phone);
			tx.commit();
			System.out.println("1 child removed");
		 }//try
		 catch(Exception e){
			tx.rollback();
		 }
	}//method
	
	@Override
	public void deleteAllChildsOfParent() {
		Session ses=null;
		User user=null;
		Set<PhoneNumber> childs=null;
		PhoneNumber phone=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load parent
		user=(User)ses.get(User.class,1001);
		//load all childs
		childs=user.getPhones();
		 try{
			tx=ses.beginTransaction();
				childs.removeAll(childs);
			tx.commit();
			System.out.println("1 child removed");
		 }//try
		 catch(Exception e){
			tx.rollback();
		 }
		
	}//method
	@Override
	public void addChildToExistingParent() {
		Session ses=null;
		User user=null;
		Set<PhoneNumber> childs=null;
		PhoneNumber newPhone=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load parent
		user=(User)ses.get(User.class,1001);
		//load all childs
		childs=user.getPhones();
		// prepare new child 
		newPhone=new PhoneNumber();
		newPhone.setPhone(7777777);
		newPhone.setNumberType("night calls");
		try{
		 tx=ses.beginTransaction();
		  //add new child to collection
		  childs.add(newPhone);
		 tx.commit();
		 System.out.println("New child added");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
	@Override
	public void deleteParentAnditsChilds() {
		Session ses=null;
		User user=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load parent object
		user=ses.get(User.class,1001);
		//delete parent obj its associated child objs
		try{
		 tx=ses.beginTransaction();
		   ses.delete(user);
		 tx.commit();
		 System.out.println("Parent and its childs are deleted");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
}// class

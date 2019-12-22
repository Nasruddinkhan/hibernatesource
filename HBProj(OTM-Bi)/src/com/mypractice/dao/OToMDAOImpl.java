package com.mypractice.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.PhoneNumber;
import com.mypractice.domain.User;
import com.mypractice.utility.HibernateUtil;

public class OToMDAOImpl implements OToMDAO {

	@Override
	public void saveDataUsingUser() {
		Session ses=null;
		User user=null;
		PhoneNumber ph1=null,ph2=null;
		HashSet<PhoneNumber> childs=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare parent ,child objs
		//parent obj
		user=new User();
		user.setUserId(1001);
		user.setFirstName("nasru");
		//child objs
		ph1=new PhoneNumber();
		ph1.setPhone(9999999);
		ph1.setNumberType("office");
		ph2=new PhoneNumber();
		ph2.setPhone(888888);
		ph2.setNumberType("residence");
		//set childs to parent
		childs=new HashSet<PhoneNumber>();
		childs.add(ph1); childs.add(ph2);
		user.setPhones(childs);
		//set parent to childs
		ph1.setUser(user);
		ph2.setUser(user);
		//save objs (parent to child)
		try{
		 tx=ses.beginTransaction();
		   ses.save(user);
		  tx.commit();
		  System.out.println("objects are saved");
		}//try
		catch(Exception e){
			tx.rollback();
		}//catch
	}//method
	@Override
	public void saveDataUsingPhoneNumber() {
		Session ses=null;
		User user=null;
		PhoneNumber ph1=null,ph2=null;
		HashSet<PhoneNumber> childs=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare parent ,child objs
		//parent obj
		user=new User();
		user.setUserId(1002);
		user.setFirstName("ravi");
		//child objs
		ph1=new PhoneNumber();
		ph1.setPhone(7777777);
		ph1.setNumberType("office");
		ph2=new PhoneNumber();
		ph2.setPhone(666666);
		ph2.setNumberType("residence");
		//set childs to parent
		childs=new HashSet<PhoneNumber>();
		childs.add(ph1); childs.add(ph2);
		user.setPhones(childs);
		//set parent to childs
		ph1.setUser(user);
		ph2.setUser(user);
		//save objs (child to parent)
		try{
		 tx=ses.beginTransaction();
		  ses.save(ph1); ses.save(ph2);
		  tx.commit();
		  System.out.println("objects are saved");
		}//try
		catch(Exception e){
			tx.rollback();
		}//catch
		
	}//methid
	@Override
	public void loadDataUsingUser() {
		Session ses=null;
		Query query=null;
		List<User> list=null;
		Set<PhoneNumber> childs=null;
		//get Session
		ses=HibernateUtil.getSession();
		//HQL (parent to child)
		query=ses.createQuery("from User");
		list=query.list();
		for(User user:list){
			System.out.println("parent---->"+user);
			//get childs of each parent
			childs=user.getPhones();
		 for(PhoneNumber ph:childs){
			 System.out.println("child---->"+ph);
		 }//for
			
		}//for
		
	}//method
	
	@Override
	public void loadDataUsingPhoneNumber() {
		Session ses=null;
		Query query=null;
		List<PhoneNumber> list=null;
		User user=null;
		//get Session
		ses=HibernateUtil.getSession();
		//HQL (parent to child)
		query=ses.createQuery("from PhoneNumber");
		list=query.list();
		for(PhoneNumber ph:list){
			System.out.println("child---->"+ph);
		   //get Parent
			user=ph.getUser();
			System.out.println("parent---->"+user);
		}//for
		
	}//method
	
	@Override
	public void deleteUsingUser() {
		Session ses=null;
		Query query=null;
		User user=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//load parent obj
		user=(User)ses.get(User.class,1001);
		try{
		 tx=ses.beginTransaction();
		   ses.delete(user);
		 tx.commit();
		 System.out.println("parent and its childs are deleted");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
	@Override
	public void deleteUsingPhoneNumber() {
		Session ses=null;
		Query query=null;
		User user=null;
		Set <PhoneNumber> childs=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//get parent
		user=(User)ses.get(User.class,1002);
		//get childs of parent
		childs=user.getPhones();
		try{
		 tx=ses.beginTransaction();
		   for(PhoneNumber ph:childs){
			   ses.delete(ph);
		   }//for
		  tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
		}
		
	}//method
	
	//using joings from parent to child
	private static final String GET_USER_USING_JOINS="SELECT u.userId,p.phone from User u full  join u.phones p";
	
	public void listDataUsingJoinsAndUser(){
		Session ses=null;
		Query query=null;
		List<Object[]> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare HQL
	    query=ses.createQuery(GET_USER_USING_JOINS);
	    //execute HQL
	    list=query.list();
	    for(Object[] row:list){
	    	for(Object val:row){
	    		System.out.print(val+"  ");
	    	}
	    	System.out.println();
	    }
	}//listDataUisngJoins
	
	//using joings from parent to child
		private static final String GET_PHONENUMBER_USING_JOINS="select p.phone,u.userId from PhoneNumber p full join p.user u";
	@Override
	public void listDataUsingJoinsAndPhoneNumber() {
		Session ses=null;
		Query query=null;
		List<Object[]>list=null;
		//get Session Session
		ses=HibernateUtil.getSession();
	    //prepare Query
		query=ses.createQuery(GET_PHONENUMBER_USING_JOINS);
		//execute Query
		list=query.list();
		//process the ResultSet
		for(Object row[]:list){
			for(Object val:row){
				System.out.print(val+"  ");
			}//for
			System.out.println();
		}//for
		
	}//class
	
	private static final String 
	 GET_USERS_USING_FETCH_JOINS="select u from User u inner join fetch u.phones";
	@Override
	public void listDataUisngFetchJoinAndUser() {
		Session ses=null;
		Query query=null;
		List<User> list=null;
		Set<PhoneNumber> childs=null;
		//get Session Session
		ses=HibernateUtil.getSession();	
		//prepare and execute Query
		query=ses.createQuery(GET_USERS_USING_FETCH_JOINS);
		list=query.list();
		//process the results
		for(User user:list){
			System.out.println("parent--->"+user);
			//get childs of each parent 
			childs=user.getPhones();
			for(PhoneNumber ph:childs){
				System.out.println("child ---->"+ph);
			}//for
		}//for
	}//for
	
	@Override
	public void loadDataUsingQBC() {
		Session ses=null;
		List<User> list=null;
		Set<PhoneNumber> childs=null;
		Criteria criteria=null;
		//get Session Session
		ses=HibernateUtil.getSession();
		//prpeare Criterial obj
		criteria=ses.createCriteria(User.class);
		//set Fecthmode
		criteria.setFetchMode("phones",FetchMode.JOIN);
		//execute QBC logic
		list=criteria.list();
		//process the reuslts
		for(User user:list){
			System.out.println("parent---->"+user);
			//get childs of parent
			childs=user.getPhones();
			for(PhoneNumber ph:childs){
				System.out.println("child----->"+ph);
			}//for
		}//for
	}//method
	
	
}//class


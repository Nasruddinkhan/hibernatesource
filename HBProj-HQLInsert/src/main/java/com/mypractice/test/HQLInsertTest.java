package com.mypractice.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.utility.HibernateUtil;

public class HQLInsertTest {
	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
		int coumypractice=0;
		//Get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("insert into NGOMember(no,fname,lname,mail) select no,fname,lname,mail from  EmpDetails where no>=:min and no<=:max");
		query.setInteger("min",1000);
		query.setInteger("max",2000);
		try{
			tx=ses.beginTransaction();
			coumypractice=query.executeUpdate();
			tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
		}
		System.out.println("no.of recors that are effected"+coumypractice);

		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class

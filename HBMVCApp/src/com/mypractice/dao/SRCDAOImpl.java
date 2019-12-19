package com.mypractice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.bo.StudentBO;
import com.mypractice.utility.HibernateUtil;


public class SRCDAOImpl implements SRCDAO {

	@Override
	public int insert(StudentBO bo) {
		Session ses=null;
		Transaction tx=null;
		int count=0;
		//get Session
		ses=HibernateUtil.getSession();
		//write persistence logic
		try{
		tx=ses.beginTransaction();
		  ses.save(bo);
		tx.commit();
		count=1;
		}
		catch(Exception e){
			count=0;
		}
		HibernateUtil.closeSession();
		return count;
	}//method

}//class

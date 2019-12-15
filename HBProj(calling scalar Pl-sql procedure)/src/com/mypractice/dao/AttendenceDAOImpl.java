package com.mypractice.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mypractice.utility.HibernateUtil;

public class AttendenceDAOImpl implements AttendenceDAO {

	@Override
	public List<Object[]> calcAttendence(int no) {
		Query query=null;
		Session ses=null;
		//get Session
		ses=HibernateUtil.getSession();
		List<Object[]>list=null;
		// get Access to Named SQL Query
		query=ses.getNamedQuery("attendence_details");
		//set param value
		query.setInteger("sno",no);
		//execute the SQL Query
		list=query.list();
		return list;
	}//method
}//class


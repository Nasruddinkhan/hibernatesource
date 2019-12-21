package com.mypractice.dao;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.Session;

import com.mypractice.domain.Student;
import com.mypractice.utility.HibernateUtil;

public class FilterDAOImpl implements FilterDAO{
	private static final String GET_STUDENTS_BY_RANGE="FROM Student";
	@Override
	public List<Student> getStudsByRange(int start, int end) {
		Session ses=null;
		Filter filter=null;
		List<Student> list=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		//enable Filter
		filter=ses.enableFilter("STUDS_BY_RANGE");
		//set filter param values
		filter.setParameter("min",start);
		filter.setParameter("max",end);
		//prepare HQL Query
		query=ses.createQuery(GET_STUDENTS_BY_RANGE);
		//excute Logic
		list=query.list();
		return list;
	}//method
}//class

package com.mypractice.dao;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.JobType;
import com.mypractice.domain.Person;
import com.mypractice.utility.HibernateUtil;

public class PersonDAOImpl implements PersonDAO {
	private static final String GET_PERSON_DETAILS="from Person where pjob.job=:desg";

	@Override
	public int saveData() {
		Session ses=null;
		JobType jt=null;
		Person person=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		// create Domain class obj through composition
	    jt=new JobType();
		jt.setJob("clerk");jt.setDepartmemypractice(1001);jt.setSalary(9000);
		person=new com.mypractice.domain.Person();
		person.setPname("Nasruddin khan");
		person.setPjob(jt);
		//save obj
		try{
		 tx=ses.beginTransaction();
		  ses.save(person);
		 tx.commit();
		  return 1;
		}
		catch(Exception e){
			tx.rollback();
			return 0;
		}
	}//method
	
	@Override
	public List<Person> getPersonDetails(String desg) {
		Session ses=null;
		Person person=null;
		Query query=null;
		List<Person> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load the object
		query=ses.createQuery(GET_PERSON_DETAILS);
		query.setString("desg",desg);
		list=query.list();
		return list;
	}
}//class

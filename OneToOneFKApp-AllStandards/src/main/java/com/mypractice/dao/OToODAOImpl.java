package com.mypractice.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.License;
import com.mypractice.domain.Person;
import com.mypractice.utility.HibernateUtil;

public class OToODAOImpl implements OToODAO {

	
	public List<License> loadPersonsWithLicense() {
		Session ses=null;
		Query query=null;
		List<License> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		//get Named Query
		query=ses.getNamedQuery("GET_ALL_LICENSE_DETAILS");
		//execute Query
		list=query.list();
		System.out.println("with Licnse..."+list.size());
		return list;
	}//method
	
	public List<Person> loadPersonsWithOutLicense() {
		Session ses=null;
		Query query=null;
		List<Person> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		//get Named Query
		query=ses.getNamedQuery("GET_PERSON_DETAILS_WITHOUT_LICENSE");
		//execute Query
		list=query.list();
		System.out.println("with outLicnse..."+list.size());
		return list;
	}//methoid
	
	public Person loadPerson(int pid) {
		Session ses=null;
		Person person=null;
	   //get Session
		ses=HibernateUtil.getSession();
		//load person
		person=(Person)ses.get(Person.class,pid);
		return person;
	}
	
	public void saveLicenseWithPerson(License lic) {
		Session ses=null;
		Transaction tx=null;
		int licId=0;
	   //get Session
		ses=HibernateUtil.getSession();
		//save obj
		try{
		 tx=ses.beginTransaction();
		  ses.saveOrUpdate(lic);
		  tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
}//class


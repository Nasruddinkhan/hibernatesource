package com.mypractice.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.Student;
import com.mypractice.utility.HibernateUtil;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public List<Student> getAllStudents() {
		System.out.println("StudentDAOImpl.getAllStudents()");
		Session ses=null;
		Query query=null;
		List<Student> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		//get NamedQuery and execute Query
		query=ses.getNamedQuery("GET_ALL_STUDS");
		list=query.list();
		return list;
	}//method
	
	@Override
	public Student getStudentRecord(int no) {
		Session ses=null;
		Student st=null;
	   // getSesion
		ses=HibernateUtil.getSession();
	   //load obj
	   st=(Student)ses.get(Student.class,no);
		return st;
	}
	@Override
	public int updateStudentRecord(Student stud) {
	Session ses=null;
	Transaction tx=null;
	int count=0;
	Query query=null;
    // getSesion
	ses=HibernateUtil.getSession();
	// Access named HQL Query and execute it
	query=ses.getNamedQuery("UPDATE_STUD_DETAILS");
	query.setString("newName",stud.getSname());
	query.setString("newAddrs",stud.getAddress());
	query.setInteger("oldNo",stud.getSno());
	try{
	 tx=ses.beginTransaction();
	   count=query.executeUpdate();
	 tx.commit();
	}//try
	catch(Exception e){
		tx.rollback();
	}
	return count;
   }//method
	
}//class


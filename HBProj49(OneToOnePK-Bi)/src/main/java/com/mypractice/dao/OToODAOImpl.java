package com.mypractice.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.LibraryMembership;
import com.mypractice.domain.Student;
import com.mypractice.utility.HibernateUtil;

public class OToODAOImpl implements OToODAO {
	public void saveDataUsingStudent() {
		Session ses=null;
		Student raja=null;
		LibraryMembership rajaLib=null;
		Transaction tx=null;
		// get Session
		ses=HibernateUtil.getSession();
		//create parnet,child objs
		raja=new Student();
		raja.setSname("nasru");
        raja.setAddress("hyd");
        
        rajaLib=new LibraryMembership();
        rajaLib.setJoiningDate(new Date(2010));
        //map parent to child and child to parent
        raja.setLibraryDetails(rajaLib);
        rajaLib.setStudentDetails(raja);
        //save data
        try{
         tx=ses.beginTransaction();
           ses.save(raja);
         tx.commit();
        }//try
        catch(Exception e){
          tx.rollback();
        }
        System.out.println("objs are saved...");
		
	}//method
	
	public void saveDataUsingLibraryMembership() {
		Session ses=null;
		Student ravi=null;
		LibraryMembership raviLib=null;
		Transaction tx=null;
		// get Session
		ses=HibernateUtil.getSession();
		//create parnet,child objs
		ravi=new Student();
		ravi.setSname("ravi");
        ravi.setAddress("hyd");
        
        raviLib=new LibraryMembership();
        raviLib.setJoiningDate(new Date());
        //map parent to child and child to parent
        ravi.setLibraryDetails(raviLib);
        raviLib.setStudentDetails(ravi);
        //save data
        try{
         tx=ses.beginTransaction();
           ses.save(raviLib);
         tx.commit();
        }//try
        catch(Exception e){
          tx.rollback();
        }
        System.out.println("objs are saved...");
		
	}//mehtid
	public void loadDataUsingStudent() {
		Session ses=null;
		Query query=null;
		LibraryMembership lib=null;
		Transaction tx=null;
		// get Session
		ses=HibernateUtil.getSession();
		List<Student> list=null;
		// get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("from Student");
		list=query.list();
		for(Student st:list){
			System.out.println("parent--->"+st);
		  lib=st.getLibraryDetails();
		   System.out.println("child --->"+lib);
		}//for
	}//method
	
	public void loadDataUsingLibraryMembership() {
		Session ses=null;
		Query query=null;
		Student st=null;
		Transaction tx=null;
		List<LibraryMembership> list=null;
		// get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("from LibraryMembership");
		list=query.list();
		for(LibraryMembership lib:list){
			System.out.println("child--->"+lib);
		  st=lib.getStudentDetails();
		   System.out.println("parent --->"+st);
		}//for
		
	}
	
}//class

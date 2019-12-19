package com.mypractice.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mypractice.domain.Student;
import com.mypractice.utility.HibernateUtil;

public class AnnotationNamedNativeSQLTest {

	public static void main(String[] args) {
		//get Session 
		Session ses=HibernateUtil.getSession();
		//Access execute NamedQuery1
		Query query1=ses.getNamedQuery("GET_ALL_STUDENTS");
		List<Student> stlist=query1.list();
		for(Student st:stlist){
			System.out.println(st);
		}
		//Access execute NamedQuery
		Query query2=ses.getNamedQuery("GET_NAME_BY_CITY");
		query2.setString("city","hyd");
		List<String>list2=query2.list();
		for(String name:list2){
			System.out.println(name+"  ");
		}
		
		
		
      //close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}

}

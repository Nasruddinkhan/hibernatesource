package com.mypractice.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.Session;

import com.mypractice.domain.EmpDetails;
import com.mypractice.utility.HibernateUtil;

public class FilterTest {

	public static void main(String[] args) {
		Session ses=null;
		Filter filter=null;
		Query query=null;
		List<EmpDetails> list=null;
		List<?>cmypracticeList=null;
		//Get Session
		ses=HibernateUtil.getSession();
		//Enable Filter
		filter=ses.enableFilter("EMPS_BY_RANGE");
		filter.setParameter("min",100);
		filter.setParameter("max",200);
		//execute HQL Logics
		query=ses.createQuery("from EmpDetails");
		list=query.list();  //executes with Filter cond
		for(EmpDetails ed:list){
			System.out.println(ed);
		}
		//Disable Filter
		ses.disableFilter("EMPS_BY_RANGE");
		//execute HQL logic
		query=ses.createQuery("select count(*) from EmpDetails");
		cmypracticeList=query.list(); //executes with out filter cond
		System.out.println("Emp coumypractice::"+cmypracticeList.get(0));
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}

}

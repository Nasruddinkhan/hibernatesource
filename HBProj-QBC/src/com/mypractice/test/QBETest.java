package com.mypractice.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import com.mypractice.domain.EmpDetails;
import com.mypractice.utility.HibernateUtil;

public class QBETest {

	public static void main(String[] args) {
		Session ses=null;
		// get Session
		ses=HibernateUtil.getSession();
		
	//create Domain obj with Data
	EmpDetails details=new EmpDetails();
	details.setNo(101);
	details.setFname("nasruddin");
	details.setLname("khan");
	details.setMail("com");
	//create Example obj
	Example empExample=Example.create(details)
			          .enableLike(MatchMode.ANYWHERE)
			          .ignoreCase()
			          .excludeProperty("lname");
	//create Criteria
	Criteria criteria=ses.createCriteria(EmpDetails.class);
	criteria.add(empExample);
	//execute QBC
	List<EmpDetails> list=criteria.list();
	//process the Result
	for(EmpDetails ed:list){
		System.out.println(ed);
	}//for
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
		
		

	}

}

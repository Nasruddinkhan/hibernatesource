package com.mypractice.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.Programmer;
import com.mypractice.domain.Project;
import com.mypractice.utility.HibernateUtil;

public class MToMDAOImpl implements MToMDAO {
	
	@Override
	public void saveDataUsingProject() {
	Session ses=null;
	Programmer prgmr1=null,prgmr2=null,prgmr3=null;
	Project proj1=null,proj2=null;
	Transaction tx=null;
	 //get Session
	ses=HibernateUtil.getSession();
	//create parent objs
	prgmr1=new Programmer();
	prgmr1.setPid(101);
	prgmr1.setPname("nasru");
	prgmr1.setSalary(9000);
	
	prgmr2=new Programmer();
	prgmr2.setPid(102);
	prgmr2.setPname("ravi");
	prgmr2.setSalary(8000);
	
	prgmr3=new Programmer();
	prgmr3.setPid(103);
	prgmr3.setPname("rakesh");
	prgmr3.setSalary(7000);
	
	proj1=new Project();
	proj1.setProid(1001);
	proj1.setProname("proj1");
	
	proj2=new Project();
	proj2.setProid(1002);
	proj2.setProname("proj2");
	
	//add programmers to projects
	proj1.getProgrammers().add(prgmr1);
	proj1.getProgrammers().add(prgmr2);
	proj1.getProgrammers().add(prgmr3);
	
	proj2.getProgrammers().add(prgmr2);
	proj2.getProgrammers().add(prgmr3);
	try{
	 tx=ses.beginTransaction();
	   ses.save(proj1);
	   ses.save(proj2);
	  tx.commit();
	}//try
	catch(Exception e){
		tx.rollback();
	}
	System.out.println("parent and child objs are saved...");
 }//method

}//class

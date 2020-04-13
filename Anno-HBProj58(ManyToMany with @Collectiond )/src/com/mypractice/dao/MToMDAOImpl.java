package com.mypractice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.Programmer;
import com.mypractice.domain.Project;
import com.mypractice.utility.HibernateUtil;

public class MToMDAOImpl implements MToMDAO {

	@Override
	public void saveData() {
	 Session ses=null;
	 Programmer prgmr1=null,prgmr2=null,prgmr3=null;
	 Project proj1=null,proj2=null;
	 Transaction tx=null;
	 //get Session
	 ses=HibernateUtil.getSession();
	 //create parent objs
	 prgmr1=new Programmer();
	 prgmr1.setPid(101);
	 prgmr1.setPname("nasrud");
	 prgmr1.setSalary(9000);
	 prgmr2=new Programmer();
	 prgmr2.setPid(102);
	 prgmr2.setPname("maslu");
	 prgmr2.setSalary(8000);
	 prgmr3=new Programmer();
	 prgmr3.setPid(103);
	 prgmr3.setPname("samsu");
	 prgmr3.setSalary(7000);
	 //create child objs
	 proj1=new Project();
	 proj1.setProid(1001);
	 proj1.setProname("proj1");
	 proj2=new Project();
	 proj2.setProid(1002);
	 proj2.setProname("proj2");
	 //set parents to childs
	 prgmr1.getProjects().add(proj1);
	 prgmr1.getProjects().add(proj2);
	 prgmr2.getProjects().add(proj2);
	 prgmr3.getProjects().add(proj1);
	 //save objs (parent to child)
	 try{
	   tx=ses.beginTransaction();
	    ses.save(prgmr1);
	    ses.save(prgmr2);
	    ses.save(prgmr3);
	   tx.commit();
	 }//try
	 catch(Exception e){
		 tx.rollback();
	 }
	 System.out.println("Objects are saved...");
	}//saveData()
}//class

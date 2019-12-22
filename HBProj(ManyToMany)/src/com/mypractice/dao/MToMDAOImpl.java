package com.mypractice.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.dao.MToMDAO;
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
	 prgmr1.setPname("Nasru");
	 prgmr1.setSalary(9000);
	 
	 prgmr2=new Programmer();
	 prgmr2.setPid(102);
	 prgmr2.setPname("ravi");
	 prgmr2.setSalary(8000);
	 
	 prgmr3=new Programmer();
	 prgmr3.setPid(103);
	 prgmr3.setPname("jani");
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
	/* //set childs to parents
	 proj1.getProgrammers().add(prgmr1);
	 proj1.getProgrammers().add(prgmr3);
	 
	 proj2.getProgrammers().add(prgmr1);
	 proj2.getProgrammers().add(prgmr2);*/
	 //save objs
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
	
	private static final String GET_DATA_USING_PROGRAMMERS=" from Programmer";
	@Override
	public void loadDataUsingProgrammers() {
	 Session ses=null;
	 Transaction tx=null;
	 Query query=null;
	 List<Programmer> list=null;
	 Set<Project> childs=null;
	 //get Session
	 ses=HibernateUtil.getSession();
	 //prepare and execute Query
	 query=ses.createQuery(GET_DATA_USING_PROGRAMMERS);
	 list=query.list();
	 for(Programmer prgmr:list){
		 System.out.println("parent--->"+prgmr);
		 //get childs of a parent
		 childs=prgmr.getProjects();
	   for(Project proj:childs){
		   System.out.println("child---->"+proj);
	   }//for
	 }//for
  }//method
	

 private static final String GET_DATA_USING_PROJECT=" from Project";
 @Override
public void loadDataUsingProjects() {
	 Session ses=null;
	 Transaction tx=null;
	 Query query=null;
	 List<Project> list=null;
	 Set<Programmer> childs=null;
	 //get Session
	 ses=HibernateUtil.getSession();
	 //prepare and execute Query
	 query=ses.createQuery(GET_DATA_USING_PROJECT);
	 list=query.list();
	 //process data
	 for(Project proj:list){
		 System.out.println("child--->"+proj);
		 //get childs of a parent
		 childs=proj.getProgrammers();
	   for(Programmer prgmr:childs){
		   System.out.println("parent---->"+prgmr);
	   }//for
	 }//for
	 
}//method
 
 @Override
public void deleteUsingProgrammer() {
	 Session ses=null;
	 Transaction tx=null;
	 Query query=null;
	 Programmer prgmr=null;
	 Set<Project> childs=null;
	 //get Session
	 ses=HibernateUtil.getSession();
	 //load parent obj
	 prgmr=ses.get(Programmer.class,101);
	 //get all childs 
	 childs=prgmr.getProjects();
	 try{
	  tx=ses.beginTransaction();
	     childs.removeAll(childs);
	   tx.commit();
	 }//try
	 catch(Exception e){
		 tx.rollback();
	 }
	 System.out.println("All chids are deleted");
}
 @Override
public void AddExistingProgrammerNewProject() {
	 Session ses=null;
	 Programmer prgmr=null;
	 Project proj=null;
	 Set<Project> projects=null;
	 Transaction tx=null;
	//get Session
	 ses=HibernateUtil.getSession();
	 //load existing programmer
	 prgmr=ses.get(Programmer.class,101);
	 //create new Project
	 proj=new Project();
	 proj.setProid(1003);
	 proj.setProname("proj3");
	 //get all the existng projects of a programmer
	 projects=prgmr.getProjects();
	 //add new project existing projects of programmer
	 try{
	  tx=ses.beginTransaction();
	    projects.add(proj);
	  tx.commit();
	 }//try
	 catch(Exception e){
		 tx.rollback();
	 }
	 
	 System.out.println("new Project is added existing programmer");
  }//method
 
 @Override
public void addExistingProgrammerExisitngProject() {
	 Session ses=null;
	 Programmer prgmr=null;
	 Project proj=null;
	 Set<Project> projects=null;
	 Transaction tx=null;
	//get Session
	 ses=HibernateUtil.getSession();
	 //load existing programmer
	 prgmr=(Programmer)ses.get(Programmer.class,103);
	 //load existing Project
	 proj=(Project)ses.get(Project.class,1003);
	 //add existing to Programmer to Existing projects
	 projects=prgmr.getProjects();
	 
	 try{
	  tx=ses.beginTransaction();
	     projects.add(proj);
	  tx.commit();
	 }//try
	 catch(Exception e){
		 tx.rollback();
	 }
	 System.out.println("Existig programmer is added existing project");
  }//method
 
 @Override
public void releaveProgrammerFromExstingProjectAndAssingAnotherExistingProject() {
	 Session ses=null;
	 Programmer prgmr=null;
	 Project proj1,proj2=null;
	 Set<Project> projects=null;
	 Transaction tx=null;
	//get Session
	 ses=HibernateUtil.getSession();
	 //load existing programmer
	 prgmr=(Programmer)ses.get(Programmer.class,103);
	 //load existing Project to releave from
	 proj1=(Project)ses.get(Project.class,1003);
	 //load another project
	 proj2=(Project)ses.get(Project.class,1002);
	 //get All the projects of Progrrammer 103;
	 projects=prgmr.getProjects();
	 //add new Proj2 and remove proj1
	 try{
	  tx=ses.beginTransaction();
	    projects.add(proj2);
	    projects.remove(proj1);
	  tx.commit();
	 }//try
	 catch(Exception e){
	    tx.rollback();
	 }
	 System.out.println("Programmer is releaved from existing project added to another existing project");
  }//method
}//class

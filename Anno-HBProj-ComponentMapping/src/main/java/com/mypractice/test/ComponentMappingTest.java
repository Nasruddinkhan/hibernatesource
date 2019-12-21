package com.mypractice.test;

import java.util.List;

import com.mypractice.dao.PersonDAO;
import com.mypractice.dao.PersonDAOFactory;
import com.mypractice.domain.JobType;
import com.mypractice.domain.Person;
import com.mypractice.utility.HibernateUtil;

public class ComponentMappingTest {

	public static void main(String[] args) {
	  PersonDAO dao=null;
	  int count=0;
	  List<Person>list=null;
	  //get DAO
	  dao=PersonDAOFactory.getInstance();
	  //save data
	  count=dao.saveData();
	  // Load data
	  list=dao.getPersonDetails("clerk");
	  for(Person person:list){
		  System.out.println("Person");
		   System.out.println(person.getPid()+"  "+person.getPname());
		  System.out.println("JOB Details");
		  JobType pjob=person.getPjob();
		  System.out.println(pjob.getDepartmemypractice()+"  "+pjob.getJob()+" "+pjob.getSalary());
	  }//for

	  //close objs
	  HibernateUtil.closeSession();
	  HibernateUtil.closeSessionFactory();
	}//main
}//class

package com.mypractice.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.EmpDetails;
import com.mypractice.utility.HibernateUtil;

public class HQLTest {

	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		List<EmpDetails> list=null;
		Iterator<Object[]> it=null;
		List<Integer> enoList=null;
		EmpDetails details=null;
		Transaction tx=null;
		// Get session
		 ses=HibernateUtil.getSession();
		 //prepare Query obj
		 query=ses.createQuery("select ed from EmpDetails ed");
		 //execute HQL execute
		 list=query.list();
		 //process List
		 for(EmpDetails ed:list){
			 System.out.println(ed);
		 }//for 

		 //prepare Query
		 query=ses.createQuery("from EmpDetails where no>=? and no<=?");
		 //set param values
		 query.setInteger(0,1000);
		 query.setInteger(1,2000);
		 //execute Query
		 list=query.list();
		 //process the result
		 for(EmpDetails ed:list){
			 System.out.println(ed);
		 }//for
	 
		//prepare Query
		 query=ses.createQuery("from EmpDetails where mail like :domain");
		 //set param values
		 query.setString("domain","%gmail.com");
		 list=query.list();
		 //process the result
		 for(EmpDetails ed:list){
			 System.out.println(ed);
		 }
	    //prepare query (Error)
		 query=ses.createQuery("from EmpDetails where lname in (?0,?1,:community)");
		 //set param values
		 query.setString("0","khan");
		 query.setString("1","khan");
		 query.setString("community","Nasruddin");
		 //execute Query
		 list=query.list();
		 for(EmpDetails ed:list){
			 System.out.println(ed);
		 }
		 /*query=ses.createQuery("from ? ed");
		 query.setString(0, "EmpDetails");
		// query.setString(1,"khan");
		 list=query.list();
		 //process the result
		 for(EmpDetails ed:list){
			 System.out.println(ed);
		 }*/
		 
		//prepare Query
		 query=ses.createQuery("from EmpDetails");
		 Iterator<EmpDetails> it1=query.iterate();
		while(it1.hasNext()){
			 EmpDetails ed=it1.next();
			 System.out.println(ed);
		 }

		 
		 //prepare Query 
		 query=ses.createQuery("select no,mail from EmpDetails where lname=:surname");
		 //set param values
		 query.setString("surname","khan");
		List<Object[]> pList=query.list();
		 //process result
		 for(Object row[]:pList){
			for(Object val:row){
			  System.out.print(val+"  ");
			}//for
			System.out.println();
		 }//for

		//prepare Query 
		 query=ses.createQuery("select no,mail from EmpDetails where lname=:surname");
		 //set param values
		 query.setString("surname","khan");
		 //execute query
		  it=query.iterate();
		  while(it.hasNext()){
			 Object row[]=(Object[])it.next();
			 for(Object val:row){
				 System.out.print(val+" ");
			 }//for
			 System.out.println();
		  }//while

		 //prepare Query
		  query=ses.createQuery("select no from EmpDetails");
		  //execute query
		  enoList=query.list();
		  //process the result
		  for(Integer no:enoList){
			  System.out.println(no);
		  }
			

	 //prepare Query
	 query=
		 ses.createQuery("select count(*) from EmpDetails");
	 List <Long> aList=query.list();
	 long cmypractice=(Long)aList.get(0);
	 System.out.println("Records coumypractice"+cmypractice);
	 //prpeare Query
	 query=ses.createQuery("from EmpDetails where no=(select max(no) from EmpDetails)");
	 //execute query
	 list=query.list();
	 //process List
	 if(list!=null){
		 details=list.get(0);
	 }
	 System.out.println(details);


	
		query=ses.createQuery("delete from EmpDetails where mail like :dmn");
		query.setString("dmn","%gmail.com");
		tx=null;
		try{
		  tx=ses.beginTransaction();
		    int result=query.executeUpdate();
		  tx.commit();
	   System.out.println("no.of records that are effected"+result);
	    }//try
	 catch(Exception e){
	   tx.rollback();
	  }
	// Access named Query
		    query=ses.getNamedQuery("HQL_GET_EMP_DETAILS_BY_EMAIL");
		    //set param values
		    query.setInteger("start",1000);
		   query.setInteger("end",2000);
		   //execute the Query
		     list=query.list();
		    //process the results
		     for(EmpDetails ed:list){
		         System.out.println(ed);
		      }		

		//prepare Query obj (pagination)
			 query=ses.createQuery("from EmpDetails ed");
			//perform pagination
			 query.setFirstResult(4);
			 query.setMaxResults(2);
			 //execute HQL execute
			 list=query.list();
			 
			 //process List
			 for(EmpDetails ed:list){
				 System.out.println(ed);
			 }//for 
			 System.out.println("complete !!!");

	 //close objs
	 HibernateUtil.closeSession();
	 HibernateUtil.closeSessionFactory();
  }//main
}//class

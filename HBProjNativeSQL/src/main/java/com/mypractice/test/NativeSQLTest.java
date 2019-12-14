package com.mypractice.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

import com.mypractice.domain.EmpDetails;
import com.mypractice.utility.HibernateUtil;

public class NativeSQLTest {

	public static void main(String[] args) {
		Session ses=null;
		SQLQuery query=null;
		List<Object[]> list=null;
		List<EmpDetails> list1=null;
		// get Session
		ses=HibernateUtil.getSession();
		//create SQLQuery obj represemypracticeing NativeSQL Query
		query=ses.createSQLQuery("select * from Employee");
		//execute Query
		list=query.list();
		//proess the Result
		for(Object row[]:list){
			for(Object val:row){
				System.out.print(val+" ");
			}//for
			System.out.println();
		}//for
		
		//create SQLQuery obj represemypracticeing NativeSQL Query
			query=ses.createSQLQuery("select * from Employee");
			//map Enity Query result with Domain class
			query.addEntity(EmpDetails.class);
			  //peform pagination
			    query.setFirstResult(1);
			    query.setMaxResults(2);
				//execute Query
				list1=query.list();
				//proess the Result
				for(EmpDetails details:list1){
					System.out.println(details);
				}
	//execute Native SQL Select Scalar query
	query=
	 ses.createSQLQuery("select EID,FIRSTNAME from Employee WHERE EMAIL LIKE :dmn");
	 //map scalar cols with HB Data types
	 query.addScalar("EID",StandardBasicTypes.INTEGER);
	 query.addScalar("FIRSTNAME",StandardBasicTypes.STRING);
	 //set param values
	 query.setString("dmn","%gmail.com");
	 //execute query
	 list=query.list();
	 //process Results
	 for(Object[] row:list){
		 for(Object val:row){
			 System.out.print(val+" ");
			 System.out.print(val.getClass());
		 }//for
		 System.out.println();
	 }//for
//execute Native SQL Select Scalar query with aggregate Results
query= ses.createSQLQuery("select count(*) from Employee");
//query.addScalar("coumypractice(*)",StandardBasicTypes.intEGER);
List<Integer> list2=query.list();
System.out.println("Emp count"+list2.get(0));
		
 //Non-select Native SQL Query to insert record with direct values
   query=
     ses.createSQLQuery("insert into Employee values(:val1,:val2,:val3,:val4)");
   //set values to params
   query.setInteger("val1",1004);
   query.setString("val2","nasru");
   query.setString("val3","khan");
   query.setString("val4","nasru@gmail.com");
   Transaction tx=null;
   int row=0;
   try{
     tx=ses.beginTransaction();
	  row=query.executeUpdate();
	 tx.commit();
	 System.out.println("no.of records inserted::"+row);
   }//try
   catch(Exception e){
	   tx.rollback();
   }
		
		//  Executing named Native SQL Query
		   Query query1=ses.getNamedQuery("GET_EMPS_BY_EMAIL");
		 query1.setString("dmn","%gmail.com");
		 list1=query1.list();
		  for(EmpDetails ed:list1){
		    System.out.println(ed);
		   }		
		//Executing named Native SQL Query
		 Query qry1=ses.getNamedQuery("GET_DETAILS_BY_LASTNAME");
		 qry1.setString("title","khan");
		   List<Object[]> lst=qry1.list();
		  for(Object[] r:lst){
			  for(Object val:r){
				  System.out.print(val+" ");
			  }//for
			  System.out.println();
		  }//for
		Query query2=ses.getNamedQuery("DELETE_EMPS_BY_EMAIL");
		query2.setString("domain","%gmail.com");
		 Transaction tx1=null;
		  try{
		    tx1=ses.beginTransaction();
		     int coumypractice=query1.executeUpdate();
		   tx1.commit();
		    System.out.println("No.of records that are effected"+coumypractice);
		   }//try
		  catch(Exception e){
		    tx1.rollback();
		   }
		
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class

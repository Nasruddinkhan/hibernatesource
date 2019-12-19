package com.mypractice.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.mypractice.domain.EmpDetails;
import com.mypractice.utility.HibernateUtil;

public class QBCTest {
	public static void main(String[] args) {
		Session ses=null;
		// get Session
		ses=HibernateUtil.getSession();
		
		//create Criteria obj
		Criteria criteria=ses.createCriteria(EmpDetails.class);
		//execute QBC logic
		List<EmpDetails>list=criteria.list();
		//process List
		for(EmpDetails ed:list){
			System.out.println(ed);
		}//for
		//create CRiteria obj
		Criteria criteriaObj=ses.createCriteria(EmpDetails.class);
		//prepare cond1
		Criterion cond1=Restrictions.between("no",2000,2200);
		criteria.add(cond1);
		//execute QBC logic
		List<EmpDetails> objList=criteriaObj.list();
		//process the Results
		for(EmpDetails ed:objList){
			System.out.println(ed);
		}//for
		
   //create Criteria obj		
	Criteria criteriaRestriction=ses.createCriteria(EmpDetails.class);
	//prepare conditions
	Criterion restCond1=Restrictions.ge("no",100);
	Criterion restcond2=Restrictions.le("no",500);
	Criterion restcond3=Restrictions.like("mail","%gmail.com");
	//preparion andCondition
	Criterion andCond=Restrictions.and(restCond1,restcond2);
	Criterion orCond=Restrictions.or(andCond,restcond3);
	//add condtion
	criteria.add(orCond);
	//execute QBC logic
	List<EmpDetails>criteriaList=criteriaRestriction.list();
	//process the ResultSet
	for(EmpDetails ed:criteriaList){
	  System.out.println(ed);
	}
   
    //crete Criteria obj
	Criteria criteriaRest=ses.createCriteria(EmpDetails.class);
	//prepre condition
	Criterion cond=Restrictions.sqlRestriction(" email like '%gmail.com'");
	//add condition
	criteria.add(cond);
	//execute QBC logic
	List<EmpDetails> listRest =criteriaRest.list();
	//process the ResultSet
	for(EmpDetails ed:listRest){
	  System.out.println(ed);
	}

	//crete Criteria obj
	Criteria criteriaOrder=ses.createCriteria(EmpDetails.class);
	//prepare Order obj
	Order order=Order.desc("fname");
	//add order
	criteria.addOrder(order);
	//execute QBC logic
	List<EmpDetails> criteriaOrderlist=criteriaOrder.list();
	//process the Result
	for(EmpDetails ed:criteriaOrderlist){
		System.out.println(ed);
	}
  //create Criteria obj
	Criteria criteriaProjections=ses.createCriteria(EmpDetails.class);
   //create Projection objs
	Projection fname=Projections.property("fname");
	Projection lname=Projections.property("lname");
	//Add Projection objs to ProjectList
	ProjectionList pList=Projections.projectionList();
	pList.add(fname);
	pList.add(lname);
	//set ProjectionList to Crieria 
	criteriaProjections.setProjection(pList);
	//prepare condition
	Criterion condProj=Restrictions.ilike("mail","%xyz.com");
	//add condtion
	criteriaProjections.add(cond);
	//prepare Order
	Order orderProj=Order.desc("fname");
	//add Order
	criteriaProjections.addOrder(orderProj);
	
	//execute QBC logic
	List<Object[]> listcriteriaProjections=criteriaProjections.list();
	for(Object[] row:listcriteriaProjections){
		for(Object val:row){
			System.out.print(val+"  ");
		}//for
		System.out.println();
	}//for
  //Working with Projections for aggragate operations
		//create Criteria obj
    Criteria criteriaAggragate =ses.createCriteria(EmpDetails.class);
     //Create Projections
     Projection rowCnt=Projections.rowCount();
     Projection avg=Projections.avg("no");
     Projection max=Projections.max("no");
     Projection min=Projections.min("no");
      // Add Projections to ProjectionList
     ProjectionList prList=Projections.projectionList();
     prList.add(rowCnt);
     prList.add(avg);
     prList.add(max);
     prList.add(min);
     //Add ProjectionList to Criteria 
     criteriaAggragate.setProjection(prList);
     //execute QBC logic
     List<Object[]> acAgglist=criteriaAggragate.list();
     //Process the List
     Object[] row=acAgglist.get(0);
     System.out.println("Row coumypractice"+row[0]);
     System.out.println("Avg of EID"+row[1]);
     System.out.println("Max of EID"+row[2]);
     System.out.println("Min of EID"+row[3]);
	//for Pagination
    Criteria criteriaPagination=ses.createCriteria(EmpDetails.class);
  //set pagination
      criteria.setFirstResult(4);
      criteria.setMaxResults(2);
  //execute QBC logic
  		List<EmpDetails> paginationList=criteriaPagination.list();
  		
  		//process List
  		for(EmpDetails ed:paginationList){
  			System.out.println(ed);
  		}//for
    
     
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class

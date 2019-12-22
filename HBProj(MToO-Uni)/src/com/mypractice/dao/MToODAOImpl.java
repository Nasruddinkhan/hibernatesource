package com.mypractice.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.Department;
import com.mypractice.domain.EmpDetails;
import com.mypractice.utility.HibernateUtil;

public class MToODAOImpl implements MToODAO {

	@Override
	public void saveChildsWithParent() {
		Session ses=null;
		Department dept=null;
		Transaction tx=null;
		 EmpDetails emp1=null,emp2=null;
		//get Session
		 ses=HibernateUtil.getSession();
		 //parent 
		   dept=new Department();
		   dept.setDeptname("Accounts");
		   dept.setDepthead("SMITH");
		   //childs
		 emp1=new EmpDetails();
		 emp1.setEname("nasru");
		 emp1.setSalary(8000);
		 emp1.setDept(dept);
		 
		 emp2=new EmpDetails();
		 emp2.setEname("ravi");
		 emp2.setSalary(9000);
		 emp2.setDept(dept);
		//set parent to childs
		emp1.setDept(dept);
		emp2.setDept(dept);
		
		
		try{
		 tx=ses.beginTransaction();
		  ses.save(emp1);ses.save(emp2);
		 tx.commit();
		 System.out.println("Object are saved");
		 }//try
		catch(Exception e){
		  tx.rollback();
		  }
	}//method
	
	@Override
	public void loadChildsAndTheirParent() {
		Session ses=null;
		List<EmpDetails> listEmps;
		Query query=null;
		Department dept=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load objs(chid to parent)
		query=ses.createQuery("from EmpDetails");
		listEmps=query.list();
		//process the reuslts
		for(EmpDetails ed:listEmps){
			System.out.println("child---->"+ed);
		   dept=ed.getDept();
		   System.out.println("parent---->"+dept);
		}//for 
		
	}//method
	
	@Override
	public void addEmployeeToExistingDept() {
		Session ses=null;
		Department dept=null;
		EmpDetails details=null;
		Transaction tx=null;
		// get session
		ses=HibernateUtil.getSession();
		//Load existing parent(User)
		dept=(Department)ses.get(Department.class,21);
		//create new Employee
		details=new EmpDetails();
		details.setEname("Ramesh");
		details.setSalary(9000);
		//assign department to Employee
		details.setDept(dept);
		try{
		 tx=ses.beginTransaction();
		   ses.save(details);
		 tx.commit();
		 System.out.println("New Employee is added");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
	@Override
	public void addExistingEmployeeToNewDept() {
		Session ses=null;
		Department dept=null;
		EmpDetails details=null;
		Transaction tx=null;
		// get session
		ses=HibernateUtil.getSession();
		//Load existing employee
		details=(EmpDetails)ses.get(EmpDetails.class,1);
		//create new department
		dept=new Department();
		dept.setDeptname("Finance");
		dept.setDepthead("Mr.Koutilya");
		//add new dept to existing Employee
		details.setDept(dept);
		try{
		 tx=ses.beginTransaction();
		   ses.update(details);
		 tx.commit();
		 System.out.println("Employee is shifted to new Dept");
		}//try
		catch(Exception e){
		  tx.rollback();
		}
	}//method
	
	@Override
	public void deletingAllEmployeesWithDept() {
		Session ses=null;
		Department dept=null;
		EmpDetails details1=null,details2=null;
		Transaction tx=null;
		// get session
		ses=HibernateUtil.getSession();
		//Load Employees
		details1=(EmpDetails)ses.get(EmpDetails.class,2);
		details2=(EmpDetails)ses.get(EmpDetails.class,3);
		//delte employees
		try{
         tx=ses.beginTransaction();
           ses.delete(details1);
           ses.delete(details2);
         tx.commit();
         System.out.println("All Employees in dept are deleted");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
	
	@Override
	public void deleteEmployeeFromDept() {
	/*	Session ses=null;
		Department dept=null;
		EmpDetails details1=null;
		Transaction tx=null;
		// get session
		ses=HibernateUtil.getSession();
		//Load Employee
		details1=(EmpDetails)ses.get(EmpDetails.class,2);
		try{
		 tx=ses.beginTransaction();
		  ses.delete(details1);
		 tx.commit();
		 System.out.println("One Employee Deleted");
		}//try
		catch(Exception e){
			tx.rollback();
		}*/
		
		Session ses=null;
		Department dept=null;
		EmpDetails details1=null;
		Transaction tx=null;
		Query query=null;
		int count=0;
		// get session
		ses=HibernateUtil.getSession();
		//create HQL Query
		query=ses.createQuery("delete from EmpDetails where eno=:id");
		query.setInteger("id",3);
		try{
		 tx=ses.beginTransaction();
		  count=query.executeUpdate();
		 tx.commit();
		 System.out.println(count+" no.of records are deleted");
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method
}//class

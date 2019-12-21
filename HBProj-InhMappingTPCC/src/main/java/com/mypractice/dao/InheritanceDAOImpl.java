package com.mypractice.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.Customer;
import com.mypractice.domain.Employee;
import com.mypractice.domain.Person;
import com.mypractice.utility.HibernateUtil;

public class InheritanceDAOImpl implements InheritanceDAO {

	public void saveData() {
		Session ses=null;
		Person person=null;
		Employee emp=null;
		Customer cust=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//create domain class objs
		person=new Person();
		person.setName("raja");
		person.setCompany("HCL");
		
		emp=new Employee();
		emp.setName("ravi");
		emp.setCompany("Wipro");
		emp.setDepartment(1001);
		emp.setSalary(9999);
		
		cust=new Customer();
		cust.setName("rajesh");
		cust.setCompany("Infy");
		cust.setAddress("hyd");
		try{
		 tx=ses.beginTransaction();
		  ses.save(person);
		  ses.save(emp);
		  ses.save(cust);
		 tx.commit();
		}//try
		catch(Exception e){
			tx.rollback();
		}
		System.out.println("Objects are saved");
		
	}//method
	public void retrieveData() {
		Session ses=null;
		Query query=null;
		List<Person> listPerson=null;
		List<Employee> listEmployee=null;
		List<Customer> listCustomer=null;
		
		// get Session
		ses=HibernateUtil.getSession();
		// Using Person
		query=ses.createQuery("from Person");
		listPerson=query.list();
		for(Person per:listPerson){
			System.out.println(per);
		}
		System.out.println("-----------------------");
		//Using Employee
		query=ses.createQuery("from Employee");
		listEmployee=query.list();
		for(Employee emp:listEmployee){
			System.out.println(emp);
		}
		System.out.println("-----------------------");
		//Using Employee
		query=ses.createQuery("from Customer");
		listCustomer=query.list();
		for(Customer cust:listCustomer){
			System.out.println(cust);
		}
		System.out.println("-----------------------");
	}
}//class

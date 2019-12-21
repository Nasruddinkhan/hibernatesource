package com.mypractice.test;

import java.util.List;

import com.mypractice.dao.FilterDAO;
import com.mypractice.dao.FilterDAOFactory;
import com.mypractice.domain.Student;
import com.mypractice.utility.HibernateUtil;

public class FilterTest {

	public static void main(String[] args) {
		FilterDAO dao=null;
		List<Student> list=null;
		//get DAO
		dao=FilterDAOFactory.getInstance();
		//Execute logic
		list=dao.getStudsByRange(1005,1010);
		//process the Reuslt
		for(Student st:list){
			System.out.println(st);
		}
		// close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class

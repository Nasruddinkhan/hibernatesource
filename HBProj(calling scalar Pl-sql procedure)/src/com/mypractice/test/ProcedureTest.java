package com.mypractice.test;

import java.util.Arrays;
import java.util.List;

import com.mypractice.dao.AttendenceDAO;
import com.mypractice.dao.AttendenceDAOFactory;
import com.mypractice.utility.HibernateUtil;

public class ProcedureTest {

	public static void main(String[] args) {
		AttendenceDAO dao;
		List<Object[]>list=null;
		Object result[]=null;
		//get DAO
		dao=AttendenceDAOFactory.getInstance();
		list=dao.calcAttendence(1);
		if(list!=null){
		  result=list.get(0);
		  System.out.println(Arrays.toString(result));
		}//if
		else{
			System.out.println("No records found");
		}
	//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}//main
}//class

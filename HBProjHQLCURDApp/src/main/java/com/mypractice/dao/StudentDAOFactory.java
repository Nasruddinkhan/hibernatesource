package com.mypractice.dao;

public class StudentDAOFactory {
	
	public static StudentDAO getInstance(){
		return new StudentDAOImpl();
	}

}

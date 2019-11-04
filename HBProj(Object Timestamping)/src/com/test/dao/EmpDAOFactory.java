package com.test.dao;

public class EmpDAOFactory {
	
	public static EmpDAO getInstance(){
		return new EmpDAOImpl();
	}//method
}//class

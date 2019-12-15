package com.mypractice.dao;

public class FunctionDAOFactory {
	public static FunctionDAO getInstance(){
		return new FunctionDAOImpl();
	}
}

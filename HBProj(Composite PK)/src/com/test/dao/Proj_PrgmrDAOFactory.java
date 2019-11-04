package com.test.dao;

public class Proj_PrgmrDAOFactory {
	
	public static Proj_PrgmrDAO getInstance(){
		return new Proj_PrgmrDAOImpl();
	}//method
}//class

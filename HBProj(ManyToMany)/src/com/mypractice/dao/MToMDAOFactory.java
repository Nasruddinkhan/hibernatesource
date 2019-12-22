package com.mypractice.dao;

public class MToMDAOFactory {
	
	public static MToMDAO getInstance(){
		return new MToMDAOImpl();
	}

}

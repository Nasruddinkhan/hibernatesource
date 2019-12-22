package com.mypractice.dao;

public class MToODAOFactory {
	
	public static MToODAO getInstance(){
		return new MToODAOImpl();
	}

}

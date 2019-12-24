package com.mypractice.dao;

public class OToMDAOFactory {
	public static OToMDAO getInstance(){
		return new OToMDAOImpl();
	}

}

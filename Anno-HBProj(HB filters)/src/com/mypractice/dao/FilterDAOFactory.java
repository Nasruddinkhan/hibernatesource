package com.mypractice.dao;

public class FilterDAOFactory {
	public static FilterDAO getInstance(){
		return new FilterDAOImpl();
	}

}

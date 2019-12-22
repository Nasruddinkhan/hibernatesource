package com.mypractice.dao;

import com.mypractice.dao.OToMDAO;

public class OToMDAOFactory {
	public static OToMDAO getInstance(){
		return new OToMDAOImpl();
	}
	

}

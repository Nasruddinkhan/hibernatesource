package com.mypractice.dao;

import com.mypractice.dao.MToMDAO;

public class MToMDAOFactory {
	
	public static MToMDAO getInstance(){
		return new MToMDAOImpl();
	}

}

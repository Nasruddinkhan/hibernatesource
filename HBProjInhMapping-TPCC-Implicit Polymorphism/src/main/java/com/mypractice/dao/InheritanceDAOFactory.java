package com.mypractice.dao;

import com.mypractice.dao.InheritanceDAO;

public class InheritanceDAOFactory {

	public static InheritanceDAO getInstance(){
		return new InheritanceDAOImpl(); 
	}
}

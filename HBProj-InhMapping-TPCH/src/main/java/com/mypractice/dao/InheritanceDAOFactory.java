package com.mypractice.dao;

import com.mypractice.dao.InheritanceDAO;
import com.mypractice.dao.InheritanceDAOImpl;

public class InheritanceDAOFactory {

	public static InheritanceDAO getInstance(){
		return new InheritanceDAOImpl(); 
	}
}

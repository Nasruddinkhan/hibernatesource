package com.mypractice.dao;

public class InheritanceDAOFactory {

	public static InheritanceDAO getInstance(){
		return new InheritanceDAOImpl(); 
	}
}

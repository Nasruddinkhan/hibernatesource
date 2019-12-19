package com.mypractice.dao;

import com.mypractice.dao.EmployeeDAO;

public class EmployeeDAOFactory {
	public static EmployeeDAO getInstance(){
		return new EmployeeDAOImpl();
	}

}

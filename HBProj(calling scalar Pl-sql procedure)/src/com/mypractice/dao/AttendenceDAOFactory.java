package com.mypractice.dao;

public class AttendenceDAOFactory {
	
	public static AttendenceDAO getInstance(){
		return new AttendenceDAOImpl();
	}

}

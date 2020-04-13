package com.mypractice.dao;

import com.mypractice.dao.OToODAO;

public class OToODAOFactory {
	
 public static OToODAO getInstance(){
	 return new OToODAOImpl();
 }

}

package com.mypractice.dao;

import com.mypractice.dao.SRCDAO;

public class SRCDAOFactory {
	
	public static SRCDAO getInstance(){
		return new SRCDAOImpl();
	}

}

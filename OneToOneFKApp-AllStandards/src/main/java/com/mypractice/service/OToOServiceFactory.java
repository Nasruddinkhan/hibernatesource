package com.mypractice.service;

public class OToOServiceFactory {
	
	public static OToOService getInstance(){
		return new OToOServiceImpl();
	}

}

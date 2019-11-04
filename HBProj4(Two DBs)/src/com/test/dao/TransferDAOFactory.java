package com.test.dao;

public class TransferDAOFactory {
 
	public static TransferDAO getInstance(){
		return new TransferDAOImpl();
	}
}

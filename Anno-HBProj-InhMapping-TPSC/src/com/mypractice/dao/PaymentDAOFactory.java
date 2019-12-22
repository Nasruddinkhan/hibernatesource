package com.mypractice.dao;

public class PaymentDAOFactory {
	
	public static PaymentDAO getInstance(){
		return new PaymentDAOImpl();
	}

}

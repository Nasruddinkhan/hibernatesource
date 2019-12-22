package com.mypractice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.ChequePayment;
import com.mypractice.domain.CreditCardPayment;
import com.mypractice.utility.HibernateUtil;

public class PaymentDAOImpl implements PaymentDAO {
	
	@Override
	public void saveData() {
		Session ses=null;
		CreditCardPayment ccPayment=null;
		ChequePayment chPayment=null;
		Transaction tx=null;
		//get Session
	   ses=HibernateUtil.getSession();
	    tx=ses.beginTransaction();
	    try{
	    	ccPayment=new CreditCardPayment();
	    	ccPayment.setAmount(9000);
	    	ccPayment.setCcType("VISA");
	     
	    	chPayment=new ChequePayment();
	    	chPayment.setChType("Self");
	    	chPayment.setAmount(8000);
	     ses.save(ccPayment);
	     ses.save(chPayment);
	     tx.commit();
	     System.out.println("Objects are saved");
	    }//try
	    catch(Exception e){
	    	tx.rollback();
	    }
		
	}//method

}

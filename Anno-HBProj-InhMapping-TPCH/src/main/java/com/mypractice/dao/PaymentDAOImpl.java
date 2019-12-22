package com.mypractice.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.ChequePayment;
import com.mypractice.domain.CreditCardPayment;
import com.mypractice.utility.HibernateUtil;

public class PaymentDAOImpl implements PaymentDAO {
	
	public void saveData() {
		Session ses=null;
		CreditCardPayment ccPaymement=null;
		ChequePayment chPayment=null;
		Transaction tx=null;
		//get Session
	   ses=HibernateUtil.getSession();
	    tx=ses.beginTransaction();
	    try{
	    	ccPaymement=new CreditCardPayment();
	    	ccPaymement.setAmoumnt(9000);
	    	ccPaymement.setCcType("VISA");
	     
	    	chPayment=new ChequePayment();
	    	chPayment.setChType("Self");
	    	chPayment.setAmoumnt(8000);
	     ses.save(ccPaymement);
	     ses.save(chPayment);
	     tx.commit();
	     System.out.println("Objects are saved");
	    }//try
	    catch(Exception e){
	    	tx.rollback();
	    }
		
	}//method

}

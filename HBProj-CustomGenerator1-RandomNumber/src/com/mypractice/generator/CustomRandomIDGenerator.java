package com.mypractice.generator;
import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomRandomIDGenerator implements IdentifierGenerator {
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		Random random=null;
		int idVal=0;
		random=new Random();
		idVal=random.nextInt(1000000);
		return idVal; 
	}//generate(-,-)

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		Random random=null;
		int idVal=0;
		random=new Random();
		idVal=random.nextInt(1000000);
		return idVal; 
	}
}//class

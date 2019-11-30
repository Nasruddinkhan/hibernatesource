package com.mypractice.generator;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomNNIDGenerator implements IdentifierGenerator {
	public Serializable generate(SessionImplementor session, 
		                                              Object object) throws HibernateException {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		int result=0;
		try{
		 con=session.connection();
		 st=con.createStatement();
		 rs=st.executeQuery("select NNGenerator.nextVal from dual");
		 if(rs.next()){
			 result=rs.getInt(1);
		 }
		 if(result<=9)
			 return "NN000"+result;
		 else if(result<=99)
			 return "NN00"+result;
		 else if(result<=999)
			 return "NN0"+result;
		 else
			 return "NN"+result;
		}//try
		catch(Exception e){
			e.printStackTrace();
			return " Can not generate  Id value";
		}
	}//generate(-,-)

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object arg1) throws HibernateException {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		int result=0;
		try{
		 con=session.connection();
		 st=con.createStatement();
		 rs=st.executeQuery("select NNGenerator.nextVal from dual");
		 if(rs.next()){
			 result=rs.getInt(1);
		 }
		 if(result<=9)
			 return "NN000"+result;
		 else if(result<=99)
			 return "NN00"+result;
		 else if(result<=999)
			 return "NN0"+result;
		 else
			 return "NN"+result;
		}//try
		catch(Exception e){
			e.printStackTrace();
			return " Can not generate  Id value";
		}
	}


	
}//class


package com.mypractice.test;

import java.sql.Blob;
import java.sql.Clob;

import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mypractice.domain.EmpProfile;
import com.mypractice.utility.FileUtility;
import com.mypractice.utility.HibernateUtil;

public class InsertClient
{
	public static void main(String s[])throws Exception
	{
		// Get Session obj
		Session ses=HibernateUtil.getSession();
		
				
		// convert to Text file in to a Stirng
		String fileComypracticeemypractice=FileUtility.readFileAsString("C:\\Users\\nasru\\Pictures\\Camera Roll\\WIN_20191222_14_20_57_Pro.jpg");

		//Covert String data in to java.sql.Clob obj
		LobHelper helper=ses.getLobHelper();
		Clob resume=helper.createClob(fileComypracticeemypractice);
		
		//convert image file data inot byte[]
		byte fileByte[]=FileUtility.getBytesArrayFromFile("C:\\Users\\nasru\\Desktop\\sufiya.pdf");
		//convert byte[] into java.sql.Blob obj
		Blob photo=helper.createBlob(fileByte);
		
		EmpProfile eb=new EmpProfile();
		eb.setEid(1001);
		eb.setEname("raja");
		eb.setEresume(resume);
		eb.setEphoto(photo);
		
		Transaction tx=null;
		try{
			tx=ses.beginTransaction();
			   ses.save(eb);
		    tx.commit();
		    System.out.println("Successfully Inserted");
		}//try
		catch(Exception e){
			tx.rollback();
		
		}
				
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();
	}
}
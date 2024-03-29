package com.mypractice.test;

import java.sql.Blob;
import java.sql.Clob;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mypractice.domain.EmpProfile;
import com.mypractice.utility.FileUtility;
import com.mypractice.utility.HibernateUtil;


public class RetrieveClient
{
	public static void main(String s[])throws Exception
	{ 
		//Get session
		Session ses=HibernateUtil.getSession();
		
		//Load obj
		EmpProfile eb=(EmpProfile)ses.get(EmpProfile.class,1001);
		//read BLOB,CLOB objs from Domain class objs
		Clob resume=eb.getEresume();
		Blob photo=eb.getEphoto();
		
		String res1=FileUtility.createFileFromClob(resume, "c:\\store2\\newResume.pdf");
		
		String res2=FileUtility.createFileFromBlob(photo, "c:/store2/newpic.png");
		
		System.out.println(res1);
		System.out.println(res2);
		
	   HibernateUtil.closeSession();
	   HibernateUtil.closeSessionFactory();
	
	}
	
	
	
	
}

package com.test.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.test.cid.ProjPrgmrId;
import com.test.domain.Proj_Prgmr;
import com.test.utility.HibernateUtil;

public class Proj_PrgmrDAOImpl implements Proj_PrgmrDAO{

	@Override
	public void saveData() {
		Session ses=null;
		Transaction tx=null;
		ProjPrgmrId id=null,cid=null;
		Proj_Prgmr pp=null;
		//get Session
		ses=HibernateUtil.getSession();
		// Create Id class obj
		id=new ProjPrgmrId();
		id.setProj_id(1001); id.setPrgmr_id(101);
		//create domain class obj
		pp=new Proj_Prgmr();
		pp.setId(id);pp.setProj_name("proj1");
		pp.setPrgmr_name("raja");
		try{
		  tx=ses.beginTransaction();
		   cid=(ProjPrgmrId)ses.save(pp);
	      tx.commit();
	      System.out.println("Object saved Id::"+cid.getProj_id()+" "+cid.getPrgmr_id());
		}//try
		catch(Exception e){
			tx.rollback();
		}
	}//method

	@Override
	public void loadData() {
	  Session ses=null;
	  ProjPrgmrId id=null;
	 //get Session
	  ses=HibernateUtil.getSession();
	  //prepare Composiste Id value
	  id=new ProjPrgmrId();
	  id.setProj_id(1001); id.setPrgmr_id(101);
	  //load object
	  Proj_Prgmr pp=ses.get(Proj_Prgmr.class, id);
	  System.out.println(pp);
	}//method
}//class

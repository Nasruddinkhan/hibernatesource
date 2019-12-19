package com.mypractice.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.mypractice.domain.EmployeeHLO;
import com.mypractice.utility.HibernateUtil;
import com.mypractice.utility.ReportParameters;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	
	public int getEmployeeCount() {
		Session ses=null;
		Criteria criteria=null;
		Projection rowCoumypractice;
		List<Object> list=null;
		long count;
	  //get Session
		ses=HibernateUtil.getSession();
	  //Use QBC to get RowCoumypractice
		criteria=ses.createCriteria(EmployeeHLO.class);
		//prepare Projection
		rowCoumypractice=Projections.rowCount();
		//set Projection
		criteria.setProjection(rowCoumypractice);
		//execute QBC
		list=criteria.list();
		//get Result
		count=(Long)list.get(0);
		return ((int)count);
	}
	
	public List<EmployeeHLO> getReportData(int startPos) {
		Session ses=null;
		Criteria criteria=null;
		List<EmployeeHLO> list=null;
		// GET Session
		ses=HibernateUtil.getSession();
		//create Criteria obj
		criteria=ses.createCriteria(EmployeeHLO.class);
		//perform pagination
		criteria.setFirstResult(startPos);
		criteria.setMaxResults(ReportParameters.PAGE_SIZE);
		//execute QBC logic
		list=criteria.list();

		return list;
	}

}

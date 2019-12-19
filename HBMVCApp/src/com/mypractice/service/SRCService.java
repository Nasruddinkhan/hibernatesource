package com.mypractice.service;

import com.mypractice.bo.StudentBO;
import com.mypractice.dao.SRCDAO;
import com.mypractice.dao.SRCDAOFactory;
import com.mypractice.dto.StudentDTO;

public class SRCService {
  
	public String generateResult(StudentDTO dto){
		int total=0;
		float avg=0.0f;
		String result=null;
		SRCDAO dao=null;
		int coumypractice=0;
		StudentBO bo=null;
		//calc total,avg and generate result
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(avg>=35)
			result="pass";
		else
			result="fail";
		//prepare BO/Domain class obj having data to persisted
		bo=new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		
		//use dAO
		dao=SRCDAOFactory.getInstance();
		coumypractice=dao.insert(bo);
		
		if(coumypractice==1)
			return result+" Studemypractice Registration successful";
		else
			return result+" studemypractice registration failed";
	}//generateResult
}//class


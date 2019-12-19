package com.mypractice.service;

import java.util.ArrayList;
import java.util.List;

import com.mypractice.dao.EmployeeDAO;
import com.mypractice.dao.EmployeeDAOFactory;
import com.mypractice.domain.EmployeeHLO;
import com.mypractice.dto.EmployeeDTO;
import com.mypractice.utility.ReportParameters;

public class EmployeeServiceImpl implements EmployeeService {

	public List<EmployeeDTO> showReportData(int pageNo) {
		int startPos=0;
		EmployeeDAO dao=null;
		List<EmployeeHLO> listHLO=null;
		List<EmployeeDTO> listDTO=null;
		EmployeeDTO dto=null;
		//generate StartPosition
		startPos=(pageNo*ReportParameters.PAGE_SIZE)-ReportParameters.PAGE_SIZE;
		// get Report Data (Use dAO)
		dao=EmployeeDAOFactory.getInstance();
		listHLO=dao.getReportData(startPos);
		//Convert ListHLO to listDTO
		listDTO=new ArrayList<EmployeeDTO>();
		
		for(EmployeeHLO hlo:listHLO){
			dto=new EmployeeDTO();
			dto.setEid(hlo.getEid());
			dto.setFirstname(hlo.getFirstName());
			dto.setLastname(hlo.getLastName());
			dto.setEmail(hlo.getEmail());
			listDTO.add(dto);
		}//for
		return listDTO;
	}//method
	
	public int getPageCount() {
		EmployeeDAO dao=null;
		int recordsCoumypractice=0;
		int pageCoumypractice=0;
		//get DAO
		dao=EmployeeDAOFactory.getInstance();
		//use DAO
		recordsCoumypractice=dao.getEmployeeCount();
		//get pages coumypractice
		pageCoumypractice=recordsCoumypractice/ReportParameters.PAGE_SIZE;
		if(recordsCoumypractice%ReportParameters.PAGE_SIZE!=0){
			pageCoumypractice++;
		}
		return pageCoumypractice;
		
	}
	
}

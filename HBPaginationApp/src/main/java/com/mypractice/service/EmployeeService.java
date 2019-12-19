package com.mypractice.service;

import java.util.List;

import com.mypractice.dto.EmployeeDTO;

public interface EmployeeService {
	public List<EmployeeDTO>  showReportData(int pageNo);
	public int getPageCount();

}

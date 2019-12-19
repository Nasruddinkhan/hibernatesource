package com.mypractice.dao;

import java.util.List;

import com.mypractice.domain.EmployeeHLO;

public interface EmployeeDAO {
	public int getEmployeeCount();
	public List<EmployeeHLO>  getReportData(int startPos);

}

package com.test.dao;

import com.test.domain.EmpDetails;

public interface EmpDAO {
	public boolean insertEmpData(int no,String fname,String lname,String mail);
	public EmpDetails retriveEmpData(int no);
	public  boolean modifyEmpDetails(int no,String newEmail);
	public boolean deleteEmpDetails(int no);
}

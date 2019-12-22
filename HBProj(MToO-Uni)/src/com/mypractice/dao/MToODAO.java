package com.mypractice.dao;

public interface MToODAO {
	public void saveChildsWithParent();
	public  void loadChildsAndTheirParent();
	public void addEmployeeToExistingDept(); 
	public void addExistingEmployeeToNewDept();
	public void deletingAllEmployeesWithDept();
	public void deleteEmployeeFromDept();

}

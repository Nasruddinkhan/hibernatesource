package com.mypractice.dao;

public interface OToMDAO {
	public void saveData();
	public  void loadData();
	public  void deleteOneChildOfAParent();
	public void deleteAllChildsOfParent();
	public void addChildToExistingParent();
	public  void deleteParentAnditsChilds(); 

}

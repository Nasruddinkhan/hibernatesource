package com.mypractice.dao;

public interface OToMDAO {
	public void saveDataUsingUser();
	public void saveDataUsingPhoneNumber();
	public void loadDataUsingUser();
	public void  loadDataUsingPhoneNumber();
	public void deleteUsingUser();
	public void deleteUsingPhoneNumber();
	public void listDataUsingJoinsAndUser();
	public void listDataUsingJoinsAndPhoneNumber();
	public void listDataUisngFetchJoinAndUser();
	public void loadDataUsingQBC();

}

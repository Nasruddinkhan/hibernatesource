package com.mypractice.test;

import com.mypractice.dao.MToMDAO;
import com.mypractice.dao.MToMDAOFactory;
import com.mypractice.utility.HibernateUtil;

public class ClientApp {

	public static void main(String[] args) {
		MToMDAO dao=null;
		//get DAO
		dao=MToMDAOFactory.getInstance();
		//save data
		dao.saveData();
		//dao.loadDataUsingProgrammers();
		//dao.loadDataUsingProjects();
		//dao.deleteUsingProgrammer();
		//dao.AddExistingProgrammerNewProject();
		//dao.addExistingProgrammerExisitngProject();
	//	dao.releaveProgrammerFromExstingProjectAndAssingAnotherExistingProject();
		
		//close objs
		HibernateUtil.closeSession();
		HibernateUtil.closeSessionFactory();

	}

}

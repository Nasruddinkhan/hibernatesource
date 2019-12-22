package com.mypractice.dao;

import java.util.List;

import com.mypractice.domain.License;
import com.mypractice.domain.Person;

public interface OToODAO {
	
	public List<License> loadPersonsWithLicense();
	public List<Person> loadPersonsWithOutLicense();
	public Person loadPerson(int pid);
	public void saveLicenseWithPerson(License lic);

}

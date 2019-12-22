package com.mypractice.service;

import java.util.List;

import com.mypractice.dto.LicenseDTO;
import com.mypractice.dto.PersonDTO;

public interface OToOService {
	public List<LicenseDTO> getPersonsWithLicense();
	public List<PersonDTO>  getPersonsWithOutLicense(); 
	public String addLicenseToPerson(int pid,String type);
	

}

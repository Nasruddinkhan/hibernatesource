package com.mypractice.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.mypractice.dao.OToODAO;
import com.mypractice.dao.OToODAOFactory;
import com.mypractice.domain.License;
import com.mypractice.domain.Person;
import com.mypractice.dto.LicenseDTO;
import com.mypractice.dto.PersonDTO;

public class OToOServiceImpl implements OToOService {
	
 @Override
 	public List<LicenseDTO> getPersonsWithLicense() {
	 OToODAO dao=null;
	 List<License> listLic=null;
	 List<LicenseDTO> listLicDTO=null;
	 LicenseDTO licDto=null;
	 Person person=null;
	 PersonDTO personDTO=null;
	 //get DAO
 	  dao=OToODAOFactory.getInstance();
 	  listLic=dao.loadPersonsWithLicense();
 	  //convert List with Domain objs to List with DTO objs
 	  listLicDTO=new ArrayList<LicenseDTO>();
 	  for(License lic:listLic){
 		//convert License to LicenseDTO
 		licDto=new LicenseDTO();
 		licDto.setLid(lic.getLid());
 		licDto.setType(lic.getType());
 		licDto.setValidFrom(lic.getValidFrom());
 		licDto.setValidTo(lic.getValidTo());
 		//get Associate Person
 		person=lic.getLicenseHolder();
        //convert Person to PersonDTO
 		personDTO=new PersonDTO();
 		personDTO.setPid(person.getPid());
 		personDTO.setFirstName(person.getFirstName());
 		personDTO.setLastName(person.getLastName());
 		personDTO.setAge(person.getAge());
 		//set PersonDTO to LinceseDTO
 		licDto.setLicenseHolder(personDTO);
 		//add licDTO to ListDTO
 		listLicDTO.add(licDto);
 	  }//for
 	  
 	  return listLicDTO;
 	 //
 	}//method
 
 @Override
	public List<PersonDTO> getPersonsWithOutLicense() {
	   OToODAO dao=null;
	   List<Person> listPerson=null;
	   List<PersonDTO> listPersonDTO=null;
	   PersonDTO dto=null;
	   //get DAO
	   dao=OToODAOFactory.getInstance();
	   listPerson=dao.loadPersonsWithOutLicense();
	   //convert list PErson to List PErsonDTO
	   listPersonDTO=new ArrayList<PersonDTO>();
	   for(Person person:listPerson){
		  dto=new PersonDTO();
		  dto.setPid(person.getPid());
		  dto.setFirstName(person.getFirstName());
		  dto.setLastName(person.getLastName());
		  dto.setAge(person.getAge());
		  listPersonDTO.add(dto);
	   }
		return listPersonDTO;
	}//method
 public String addLicenseToPerson(int pid, String type) {
	   OToODAO  dao=null;
	   Person person=null;
	   License lic=null;
	   int licId=0;
	   Calendar cl=null;
	   
	  //get DAO
	   dao=OToODAOFactory.getInstance();
	 //get Person
	   person=dao.loadPerson(pid);
	  //create License
	   lic=new License();
	   lic.setType(type);
	   lic.setValidFrom(new Date());
	   cl=Calendar.getInstance();
	   cl.set(Calendar.YEAR,new Date().getYear()+person.getAge()+1900);
	   cl.set(Calendar.MONTH,new Date().getMonth());
	   cl.set(Calendar.DATE,new Date().getDate()-1);
	   lic.setValidTo(cl.getTime());
	   lic.setLicenseHolder(person);
	   //use DAO
	   dao.saveLicenseWithPerson(lic);
	   return lic.getType()+" License is assigned for "+pid;
	}
}//class


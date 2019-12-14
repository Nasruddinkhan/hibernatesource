package com.mypractice.service;

import java.util.ArrayList;
import java.util.List;

import com.mypractice.dao.StudentDAO;
import com.mypractice.dao.StudentDAOFactory;
import com.mypractice.domain.Student;
import com.mypractice.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<StudentDTO> retrieveAllStudents() {
		StudentDAOFactory factory=null;
		StudentDAO dao=null;
		List<Student>list=null;
		List<StudentDTO> listDTO=null;
		StudentDTO dto=null;
		//use DAO
		dao=factory.getInstance();
		list=dao.getAllStudents();
		//Convert ListDomain(list) objs to List DTO objs
		listDTO=new ArrayList<StudentDTO>();
		for(Student st:list){
			dto=new StudentDTO();
			dto.setSno(st.getSno());
			dto.setSname(st.getSname());
			dto.setAddress(st.getAddress());
			
			listDTO.add(dto);
		}//for
		return listDTO;
	}//method
	
	@Override
	public StudentDTO getStudentDetails(int no) {
		StudentDAO dao=null;
		Student st=null;
		StudentDTO dto=null;
		//use dAO
	    dao=StudentDAOFactory.getInstance();
	    st=dao.getStudentRecord(no);
	    //convert Domain obj to DTO obj
	    dto=new StudentDTO();
	    dto.setSno(st.getSno());
	    dto.setSname(st.getSname());
	    dto.setAddress(st.getAddress());
	    return dto;
	}//method
	@Override
	public String updateStudntDetails(StudentDTO dto) {
		Student stud=null;
		StudentDAO dao=null;
		int count=0;
		//convert DTO obj to domain  obj
		stud=new Student();
		stud.setSno(dto.getSno());
		stud.setSname(dto.getSname());
		stud.setAddress(dto.getAddress());
		//use dAO
		 dao=StudentDAOFactory.getInstance();
		 count=dao.updateStudentRecord(stud);
		 if(count==0)
   		    return stud.getSno()+" updatation failed";
		 else
			 return stud.getSno()+" is updated";
  	}//method
}//class

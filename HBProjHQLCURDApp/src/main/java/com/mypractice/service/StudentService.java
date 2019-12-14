package com.mypractice.service;

import java.util.List;

import com.mypractice.dto.StudentDTO;

public interface StudentService {
	
	public List<StudentDTO> retrieveAllStudents();
	public StudentDTO  getStudentDetails(int no);
	public String updateStudntDetails(StudentDTO dto);

}

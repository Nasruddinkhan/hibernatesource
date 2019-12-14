package com.mypractice.dao;

import java.util.List;

import com.mypractice.domain.Student;

public interface StudentDAO {
	public List<Student> getAllStudents();
    public Student getStudentRecord(int no);
    public int updateStudentRecord(Student stud);
}

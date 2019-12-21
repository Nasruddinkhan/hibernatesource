package com.mypractice.dao;

import java.util.List;

import com.mypractice.domain.Student;

public interface FilterDAO {
	public List<Student> getStudsByRange(int start,int end);

}

package com.mypractice.dao;

import java.util.List;

import com.mypractice.domain.Person;

public interface PersonDAO {
	public int saveData();
    public List<Person> getPersonDetails(String desg);
}

package com.mypractice.domain;

public class Person {
	private int id;
	private String name;
	private String company;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", company=" + company + "]";
	}

}

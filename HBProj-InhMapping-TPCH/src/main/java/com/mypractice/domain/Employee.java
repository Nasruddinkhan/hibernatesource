package com.mypractice.domain;

public class Employee extends Person {
	private int department;
	private long salary;
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return  super.toString()+"Employee [department=" + department + ", salary=" + salary + "]";
	}
	

}

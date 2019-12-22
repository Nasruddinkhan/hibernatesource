package com.mypractice.domain;

import com.mypractice.domain.Department;

public class EmpDetails{   //child
	  private int eno;
	  private String ename;
	  private long salary;
	  private Department dept;
	  
	  public EmpDetails() {
		System.out.println("EmpDetails:0-param constructor");
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "EmpDetails [eno=" + eno + ", ename=" + ename + ", salary=" + salary + "]";
	}
	
	
	}
package com.mypractice.domain;

import javax.persistence.Embeddable;

@Embeddable
public class JobType {
	private String job;
	private int department;
	private long salary;
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getDepartmemypractice() {
		return department;
	}
	public void setDepartmemypractice(int department) {
		this.department = department;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}

}

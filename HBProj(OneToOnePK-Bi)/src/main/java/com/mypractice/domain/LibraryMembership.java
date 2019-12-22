package com.mypractice.domain;

import java.util.Date;

public class LibraryMembership {
	 private int lid;
	 private Date joiningDate;
	 private  Student studentDetails;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Student getStudentDetails() {
		return studentDetails;
	}
	public void setStudentDetails(Student studentDetails) {
		this.studentDetails = studentDetails;
	}
	@Override
	public String toString() {
		return "LibraryMembership [lid=" + lid + ", joiningDate=" + joiningDate + "]";
	}
	
	
}

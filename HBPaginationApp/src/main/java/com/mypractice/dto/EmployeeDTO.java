package com.mypractice.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7844680816595903451L;
	private int eid;
	private String firstname,lastname,email;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}

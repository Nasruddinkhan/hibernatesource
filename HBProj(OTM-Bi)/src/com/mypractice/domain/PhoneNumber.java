package com.mypractice.domain;

import java.util.Comparator;

public class PhoneNumber {
	private long phone;
	private String numberType;
	private int uid;
	private User user;
	
	public PhoneNumber() {
	  System.out.println("PhoneNumber:0-param constructor");
	}
	
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getNumberType() {
		return numberType;
	}
	public void setNumberType(String numberType) {
		this.numberType = numberType;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "PhoneNumber [phone=" + phone + ", numberType=" + numberType + ", uid=" + uid + "]";
	}
	
	

}

package com.mypractice.domain;

public class Customer extends Person {
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return super.toString()+"Customer [address=" + address + "]";
	}
	

}

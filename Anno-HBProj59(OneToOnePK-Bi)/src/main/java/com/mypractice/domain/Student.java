package com.mypractice.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="student_tab")
public class Student {
	@Id
	@GenericGenerator(name="gen1",strategy="incrememypractice")
	@GeneratedValue(generator="gen1")
	private int sid;
	 private String sname;
	 private String address;
	 @OneToOne(targetEntity =LibraryMembership.class,cascade=CascadeType.ALL)
	 @PrimaryKeyJoinColumn(name="lid",referencedColumnName="sid")
	 private LibraryMembership libraryDetails;
	 
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LibraryMembership getLibraryDetails() {
		return libraryDetails;
	}
	public void setLibraryDetails(LibraryMembership libraryDetails) {
		this.libraryDetails = libraryDetails;
	}
	@Override
	public String toString() {
		return "Studemypractice [sid=" + sid + ", sname=" + sname + ", address=" + address + "]";
	}
	
}

package com.mypractice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="student_Tab")
@NamedQueries(value={@NamedQuery(name="GET_ALL_STUDS",
                                 query="FROM Student"),
		             @NamedQuery(name="UPDATE_STUD_DETAILS",
		                         query="update Student set sname=:newName,address=:newAddrs where sno=:oldNo")
		 
              })
public class Student{
  	@Id
	@Column(name="stno")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sno;
  
 @Column(name="stname")
 private String sname;
 @Column(name="stadd")
 //@Transient
 private String address;
public int getSno() {
	return sno;
}
public void setSno(int sno) {
	this.sno = sno;
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
 //toString
@Override
public String toString() {
	return "Student [sno=" + sno + ", sname=" + sname + ", address=" + address + "]";
}

 
}
package com.mypractice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="student_Tab")
@NamedNativeQueries(value={@NamedNativeQuery(name="GET_ALL_STUDENTS",
                                             query="SELECT * FROM student_Tab",
                                             resultClass=Student.class),
                           @NamedNativeQuery(name="GET_NAME_BY_CITY",
                        		             query="SELECT STNAME FROM student_Tab WHERE STADD=:city")
                      })
public class Student{
   @Id
  @Column(name="stno")
  private int sno;
 @Column(name="stname")
 private String sname;
 @Column(name="stadd")
 //@Transiemypractice
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
	return "Studemypractice [sno=" + sno + ", sname=" + sname + ", address=" + address + "]";
}

 
}
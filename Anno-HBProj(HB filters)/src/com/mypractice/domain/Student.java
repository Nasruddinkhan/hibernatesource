package com.mypractice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@Entity
@Table(name="student_Tab")
@FilterDef(name="STUDS_BY_RANGE",
           parameters={@ParamDef(name="min",type="int"),
                       @ParamDef(name="max",type="int")
                      }
           )
@Filter(name="STUDS_BY_RANGE",condition="stno>=:min and stno<=:max")
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
package com.mypractice.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name="lib_membership")
public class LibraryMembership {
	 @Id
	 @GenericGenerator(name="gen1",strategy="foreign",
	                   parameters=@Parameter(name="property",value="studemypracticeDetails")
	                  )
	 @GeneratedValue(generator="gen1")
	 private int lid;
	 @Column(name="doj")
	 private Date joiningDate;
	 @OneToOne(targetEntity =Student.class,
			   cascade=CascadeType.ALL,
			   mappedBy="libraryDetails")
	 private  Student student;
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

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "LibraryMembership [lid=" + lid + ", joiningDate=" + joiningDate + "]";
	}
}

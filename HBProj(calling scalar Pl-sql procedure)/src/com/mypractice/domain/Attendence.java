package com.mypractice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name="attendence_sheet")
@NamedNativeQuery(name="attendence_details",
                  query="{call CALC_ATTENDENCE_PERCENTAGE(:sno)}")
                 
public class Attendence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stno;
	private String stname;
	private float attendence_percentage;
	
	public int getStno() {
		return stno;
	}
	public void setStno(int stno) {
		this.stno = stno;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	
	public float getAttendence_percentage() {
		return attendence_percentage;
	}
	public void setAttendence_percentage(float attendence_percentage) {
		this.attendence_percentage = attendence_percentage;
	}

}

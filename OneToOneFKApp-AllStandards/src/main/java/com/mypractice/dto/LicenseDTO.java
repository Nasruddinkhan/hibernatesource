package com.mypractice.dto;

import java.io.Serializable;
import java.util.Date;

public class LicenseDTO implements Serializable {
	private int lid;
	 private String type;
	 private Date validFrom,validTo;
	 private PersonDTO licenseHolder;
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	public Date getValidTo() {
		return validTo;
	}
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
	public PersonDTO getLicenseHolder() {
		return licenseHolder;
	}
	public void setLicenseHolder(PersonDTO licenseHolder) {
		this.licenseHolder = licenseHolder;
	}
}

package com.test.domain;

import com.test.cid.ProjPrgmrId;

public class Proj_Prgmr {
	private ProjPrgmrId id;
	private String proj_name;
	private String prgmr_name;
	
	public ProjPrgmrId getId() {
		return id;
	}
	public void setId(ProjPrgmrId id) {
		this.id = id;
	}
	public String getProj_name() {
		return proj_name;
	}
	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}
	public String getPrgmr_name() {
		return prgmr_name;
	}
	public void setPrgmr_name(String prgmr_name) {
		this.prgmr_name = prgmr_name;
	}
	
	@Override
	public String toString() {
		return "Proj_Prgmr [id=" + id + ", proj_name=" + proj_name + ", prgmr_name=" + prgmr_name + "]";
	}
	

}

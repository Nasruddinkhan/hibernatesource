package com.mypractice.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHEQUE")
public class ChequePayment extends Payment {
	private String chType;

	public String getChType() {
		return chType;
	}

	public void setChType(String chType) {
		this.chType = chType;
	}

	@Override
	public String toString() {
		return super.toString()+"ChequePaymemypractice [chType=" + chType + "]";
	}
	

}

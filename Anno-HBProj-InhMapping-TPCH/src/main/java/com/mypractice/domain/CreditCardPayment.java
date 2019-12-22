package com.mypractice.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.mypractice.domain.Payment;

@Entity
@DiscriminatorValue("CREDIT")
public class CreditCardPayment extends Payment{
	private String ccType;

	public String getCcType() {
		return ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

	@Override
	public String toString() {
		return super.toString()+"CreditCardPaymemypractice [ccType=" + ccType + "]";
	}
}//class

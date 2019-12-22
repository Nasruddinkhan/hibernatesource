package com.mypractice.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.mypractice.domain.Payment;

@Entity
@Table(name="credit_Payment3")
public class CreditCardPayment extends Payment {
	private String ccType;

	public String getCcType() {
		return ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

	@Override
	public String toString() {
		return super.toString()+"CreditCardPayment [ccType=" + ccType + "]";
	}
}//class

package com.mypractice.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.mypractice.domain.Payment;

@Entity
@Table(name="cheque_paymente3")
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

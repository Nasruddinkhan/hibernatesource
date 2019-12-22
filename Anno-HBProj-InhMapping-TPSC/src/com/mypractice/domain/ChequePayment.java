package com.mypractice.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="cheque_payment2")
@PrimaryKeyJoinColumn(name="payment_id")
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
		return super.toString()+"ChequePayment [chType=" + chType + "]";
	}
	

}

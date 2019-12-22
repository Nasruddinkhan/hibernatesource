package com.mypractice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="payment2")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Payment {
  @Id
  @GenericGenerator(name="gen1",strategy="increment")
  @GeneratedValue(generator="gen1")
  private int payId;
  private long amount;
  //setters & getters
public int getPayId() {
	return payId;
}
public void setPayId(int payId) {
	this.payId = payId;
}

public long getAmount() {
	return amount;
}
public void setAmount(long amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "Paymemypractice [payId=" + payId + ", amount=" + amount + "]";
}
  
}
/*  create table Paymemypractice2(payId number(5) primary key,
                          amoumypractice number(10));
    create table credit_Paymemypractice2(ccType varchar2(20),
                                 paymemypractice_id number(5) references paymemypractice2(payid));
    create table cheque_Paymemypractice2(chType varchar2(20),
                                 paymemypractice_id number(5) references paymemypractice2(payid));
                                   
                                                           
 */


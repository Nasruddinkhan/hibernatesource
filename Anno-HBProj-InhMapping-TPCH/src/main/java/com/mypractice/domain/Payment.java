package com.mypractice.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="paymnt1")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="paytype",discriminatorType=DiscriminatorType.STRING,length=10)
public abstract class Payment {
  @Id
  @GenericGenerator(name="gen1",strategy="increment")
  @GeneratedValue(generator="gen1")
  private int payId;
  private long amoumnt;
  //setters & getters
public int getPayId() {
	return payId;
}
public void setPayId(int payId) {
	this.payId = payId;
}

public long getAmoumnt() {
	return amoumnt;
}
public void setAmoumnt(long amoumnt) {
	this.amoumnt = amoumnt;
}
@Override
public String toString() {
	return "Paymemypractice [payId=" + payId + ", amoumnt=" + amoumnt + "]";
}
  
}
/*  create table Paymemypractice1(payId number(5) primary key,
                          amoumypractice number(10),
                          ccType varchar2(20),
                          chType varchar2(20),
                          payType varchar2(10));
 */


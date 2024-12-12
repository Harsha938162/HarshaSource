package com.varahi.varahiframes.Model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Product")
public class Products {
	@Id
private int rollNo;
public int getRollNo() {
	return rollNo;
}
public void setRollNo(int rollNo) {
	this.rollNo = rollNo;
}
private String Name;
private String Address1;
private String Address2;
private String PinCode;
private String Gmail;
public String getGmail() {
	return Gmail;
}
public void setGmail(String gmail) {
	Gmail = gmail;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getAddress1() {
	return Address1;
}
public void setAddress1(String address1) {
	Address1 = address1;
}
public String getAddress2() {
	return Address2;
}
public void setAddress2(String address2) {
	Address2 = address2;
}
public String getPinCode() {
	return PinCode;
}
public void setPinCode(String pinCode) {
	PinCode = pinCode;
}

}

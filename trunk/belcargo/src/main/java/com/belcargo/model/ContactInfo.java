package com.belcargo.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT_INFO")
public class ContactInfo {
	@Id
	@Column(name = "CONTACT_INFO_PK")
	@GeneratedValue
	private BigDecimal id;
	@Column(name = "PERSON")
	private String name;
	@Column
	private String street;
	@Column
	private String phone;
	@Column(name = "PHONE_2")
	private String phone2;
	@Column
	private String fax;
	@Column
	private String email;
	@OneToOne
	@JoinColumn(name = "REG_INFO_FK")
	private RegInfo regInfo;
//	private String notes;


	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	
	public RegInfo getRegInfo() {
		return regInfo;
	}
	public void setRegInfo(RegInfo regInfo) {
		this.regInfo = regInfo;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

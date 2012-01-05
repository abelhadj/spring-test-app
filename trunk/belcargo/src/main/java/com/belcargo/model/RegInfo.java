package com.belcargo.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.belcargo.model.lut.Activity;
import com.belcargo.model.lut.Country;

@Entity
@Table(name = "REG_INFO")
public class RegInfo {
	@Id
	@Column(name = "REG_INFO_PK")
	@GeneratedValue
	private BigDecimal id;
	@Column(name = "ORGANIZATION_NAME")
	private String organizationName;
	@Column(name = "REG_DATE")
	private Date regDate;

	@OneToOne
	@JoinColumn(name = "COUNTRY_FK")
	private Country country;
	@Column
	private String city;
	
	@Column
	private String unp;
	@Column(name = "POST_INDEX")
	private String postIndex;
	@Column
	private String url;
	@OneToOne
	@JoinColumn(name = "ACTIVITY_FK")
	private Activity activity;
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUnp() {
		return unp;
	}
	public void setUnp(String unp) {
		this.unp = unp;
	}
	public String getPostIndex() {
		return postIndex;
	}
	public void setPostIndex(String postIndex) {
		this.postIndex = postIndex;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
}

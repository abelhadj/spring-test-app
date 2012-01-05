package com.belcargo.model.lut;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CITY")
public class City {
	@Id
	@Column(name = "CITY_PK")
	private BigDecimal id;
	
	@Column(name = "NAME")
	private String name;
	
	@OneToOne
	@JoinColumn(name = "COUNTRY_FK")
	private Country country;
	@OneToOne
	@JoinColumn(name = "REGION_FK")
	private Region region;
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	
}

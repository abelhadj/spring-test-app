package com.belcargo.model.lut;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY_TYPE_LUT")
public class CurrencyType {
	@Id
	@Column(name = "CURRENCY_TYPE_LUT_PK")
	private BigDecimal id;
	
	@Column(name = "SHORT_NAME")
	private String shortName;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
}

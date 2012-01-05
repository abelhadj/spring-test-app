package com.belcargo.model.lut;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACTIVITY_LUT")
public class Activity {
	@Id
	@Column(name = "ACTIVITY_LUT_PK")
	private BigDecimal id;

	@Column(name = "NAME")
	private String name;

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

}

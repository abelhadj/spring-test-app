package com.belcargo.model.lut;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Country")
public class Country implements Serializable{
	private static final long serialVersionUID = -4809772090406562799L;

	@Id
	@Column(name = "Country_PK")
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

package com.belcargo.model.lut;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRUCK_LOAD_KIND_LUT")
public class TruckLoadKind {
		@Id
		@Column(name = "TRUCK_LOAD_KIND_LUT_PK")
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

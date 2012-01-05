package com.belcargo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;

import com.belcargo.model.lut.Country;
import com.belcargo.model.lut.Region;
import com.belcargo.model.lut.TruckType;


@Entity
@Table(name = "CARS")
public class Car implements Serializable{
	private static final long serialVersionUID = 1871975065439748967L;
//	@OneToOne
//	@JoinColumn(name = "CITY_FROM")
//	private City cityFrom;
//	@OneToOne
//	@JoinColumn(name = "CITY_TO")
//	private City cityTo;

	@Id
	@Column(name = "CAR_PK")
	@GeneratedValue
	private BigDecimal id;

	@OneToOne
	@JoinColumn(name = "COUNTRY_FROM_FK")
	private Country countryFrom;
	@OneToOne
	@JoinColumn(name = "REGION_FROM_FK")
	private Region regionFrom;

	@Column(name = "CITY_FROM")
	private String cityFrom;

  	@OneToOne
  	@JoinColumn(name = "COUNTRY_TO_FK")
	private Country countryTo;
	@OneToOne
  	@JoinColumn(name = "REGION_TO_FK")
	private Region regionTo;

	@Column(name = "CITY_TO")
	private String cityTo;

	@Column(name = "PRICE")
	private String price;
	@Column(name = "CURRENCY_TYPE")
	private String currencyType;

	@OneToOne
	@JoinColumn(name = "TRUCK_TYPE_FK")
	private TruckType truckType;

	@Column(name = "MAX_WEIGHT")
	private Integer maxWeight;
	@Column(name = "MIN_WEIGHT")
	private Integer minWeight;

	@Column(name = "MAX_VOLUME")
	private Integer maxVolume;
	@Column(name = "MIN_VOLUME")
	private Integer minVolume;

	@Column(name = "START_DATE")
	private Date startDate;
	@Column(name = "END_DATE")
	private Date endDate;

	@OneToOne
	@JoinColumn(name = "CONTACT_INFO_FK")
	private ContactInfo contactInfo;
	@Column(name = "NOTES")
	private String notes;

	public BigDecimal getId() {
		return id;
	}

	public Country getCountryFrom() {
		return countryFrom;
	}

	public Region getRegionFrom() {
		return regionFrom;
	}

	public String getCityFrom() {
		return cityFrom;
	}

	public Country getCountryTo() {
		return countryTo;
	}

	public Region getRegionTo() {
		return regionTo;
	}

	public String getCityTo() {
		return cityTo;
	}

	public String getPrice() {
		return price;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public TruckType getTruckType() {
		return truckType;
	}

	public Integer getMaxWeight() {
		return maxWeight;
	}

	public Integer getMinWeight() {
		return minWeight;
	}

	public Integer getMaxVolume() {
		return maxVolume;
	}

	public Integer getMinVolume() {
		return minVolume;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public String getNotes() {
		return notes;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public void setCountryFrom(Country countryFrom) {
		this.countryFrom = countryFrom;
	}

	public void setRegionFrom(Region regionFrom) {
		this.regionFrom = regionFrom;
	}

	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}

	public void setCountryTo(Country countryTo) {
		this.countryTo = countryTo;
	}

	public void setRegionTo(Region regionTo) {
		this.regionTo = regionTo;
	}

	public void setCityTo(String cityTo) {
		this.cityTo = cityTo;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}

	public void setTruckType(TruckType truckType) {
		this.truckType = truckType;
	}

	public void setMaxWeight(Integer maxWeight) {
		this.maxWeight = maxWeight;
	}

	public void setMinWeight(Integer minWeight) {
		this.minWeight = minWeight;
	}

	public void setMaxVolume(Integer maxVolume) {
		this.maxVolume = maxVolume;
	}

	public void setMinVolume(Integer minVolume) {
		this.minVolume = minVolume;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String prepareStringForOutput(String str) {
		str = new String(StringUtils.isEmpty(str) ? "" : str);
		str = str.replaceAll("\\s+$", "");
		return str;
	}

	public String getLoading() {
		String cityName = prepareStringForOutput(getCityFrom());
		String regionName = prepareStringForOutput(getRegionFrom().getName());

		if (cityName.equalsIgnoreCase(regionName)) {
			regionName = "";
		} else {
			if (!StringUtils.isEmpty(regionName)) {
				regionName = " - " + regionName;
			}
		}

		if (!StringUtils.isEmpty(cityName)) {
			cityName = " - " + cityName;
		}

		return getCountryFrom().getName() + regionName + cityName;
	}

	public String getUnloading() {
		String cityName = prepareStringForOutput(getCityTo());
		String regionName = prepareStringForOutput(getRegionTo().getName());

		if (cityName.equalsIgnoreCase(regionName)) {
			regionName = "";
		} else {
			if (!StringUtils.isEmpty(regionName)) {
				regionName = " - " + regionName;
			}
		}

		if (!StringUtils.isEmpty(cityName)) {
			cityName = " - " + cityName;
		}

		return getCountryTo().getName() + regionName + cityName;
	}
}

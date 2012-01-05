package com.belcargo.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.belcargo.model.lut.City;
import com.belcargo.model.lut.Country;
import com.belcargo.model.lut.Region;
import com.belcargo.model.lut.TruckLoadKind;
import com.belcargo.model.lut.TruckType;


public class Loading {
	@Id
	@Column(name = "LOADING_PK")
	@GeneratedValue
	private BigDecimal id;
	
	@OneToOne
	@JoinColumn(name = "COUNTRY_FROM_FK")
	private Country countryFrom;
	@OneToOne
	@JoinColumn(name = "REGION_FROM_FK")
	private Region regionFrom;
	@OneToOne
	@JoinColumn(name = "CITY_FROM")
	private City cityFrom;  
  	
  	@OneToOne
  	@JoinColumn(name = "COUNTRY_TO_FK")
	private Country countryTo;
	@OneToOne
  	@JoinColumn(name = "REGION_TO_FK")
	private Region regionTo;
	@OneToOne
	@JoinColumn(name = "CITY_TO")
	private City cityTo;

	@Column(name = "PRICE")
	private String price;
	@Column(name = "CURRENCY_TYPE")
	private String currencyType;
	
	@OneToOne
	@JoinColumn(name = "TRUCK_TYPE_FK")
	private TruckType truckType;
	@OneToOne
	@JoinColumn(name = "TRUCK_LOAD_KIND")
	private TruckLoadKind truckLoadKind;
	
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
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public Country getCountryFrom() {
		return countryFrom;
	}
	public void setCountryFrom(Country countryFrom) {
		this.countryFrom = countryFrom;
	}
	public Region getRegionFrom() {
		return regionFrom;
	}
	public void setRegionFrom(Region regionFrom) {
		this.regionFrom = regionFrom;
	}
	public City getCityFrom() {
		return cityFrom;
	}
	public void setCityFrom(City cityFrom) {
		this.cityFrom = cityFrom;
	}
	public Country getCountryTo() {
		return countryTo;
	}
	public void setCountryTo(Country countryTo) {
		this.countryTo = countryTo;
	}
	public Region getRegionTo() {
		return regionTo;
	}
	public void setRegionTo(Region regionTo) {
		this.regionTo = regionTo;
	}
	public City getCityTo() {
		return cityTo;
	}
	public void setCityTo(City cityTo) {
		this.cityTo = cityTo;
	}
	public Integer getMaxWeight() {
		return maxWeight;
	}
	public TruckType getTruckType() {
		return truckType;
	}
	public void setTruckType(TruckType truckType) {
		this.truckType = truckType;
	}
	public TruckLoadKind getTruckLoadKind() {
		return truckLoadKind;
	}
	public void setTruckLoadKind(TruckLoadKind truckLoadKind) {
		this.truckLoadKind = truckLoadKind;
	}
	public void setMaxWeight(Integer maxWeight) {
		this.maxWeight = maxWeight;
	}
	public Integer getMinWeight() {
		return minWeight;
	}
	public void setMinWeight(Integer minWeight) {
		this.minWeight = minWeight;
	}
	public Integer getMaxVolume() {
		return maxVolume;
	}
	public void setMaxVolume(Integer maxVolume) {
		this.maxVolume = maxVolume;
	}
	public Integer getMinVolume() {
		return minVolume;
	}
	public void setMinVolume(Integer minVolume) {
		this.minVolume = minVolume;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public ContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}

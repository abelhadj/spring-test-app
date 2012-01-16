package com.belcargo.managedbeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import com.belcargo.application.LocationProviderService;
import com.belcargo.application.RegistrationService;
import com.belcargo.model.ContactInfo;
import com.belcargo.model.RegInfo;
import com.belcargo.model.lut.Activity;
import com.belcargo.model.lut.City;
import com.belcargo.model.lut.Country;

@ManagedBean(name = "regBean")
@ViewScoped
public class RegistrationBean extends LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{registrationService}")
	private RegistrationService registrationService;
	@ManagedProperty(value = "#{locationService}")
	private LocationProviderService locationProviderService;

	private BigDecimal countryId = null;
    private BigDecimal activityId = null;
    private BigDecimal cityId = null;
    private List<Country> countries;
    private List<City> cities;
    private List<Activity> activities;
    private ContactInfo contactInfo;

    public List<Country> getCountries() {

//        if(countries==null)
            countries=locationProviderService.getCountries();
        return countries;
    }

    public List<City> getCities() {

        if(cities==null)
           cities = locationProviderService.getCities(countryId);
        return cities;
    }

	public void register() {
		registrationService.registerUser(getLogin(), getPassword());
		getAuthenticationService().login(getLogin(), getPassword());
	}

	 public void valueChanged(ValueChangeEvent event){
         cities = null;
         countryId = ((BigDecimal)event.getNewValue());
     }

	public void setRegistrationService(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}

	public void setLocationProviderService(
			LocationProviderService locationProviderService) {
		this.locationProviderService = locationProviderService;
	}

	public BigDecimal getCountryId() {
		return countryId;
	}

	public BigDecimal getCityId() {
		return cityId;
	}

	public void setCountryId(BigDecimal countryId) {
		this.countryId = countryId;
	}

	public void setCityId(BigDecimal cityId) {
		this.cityId = cityId;
	}

	public ContactInfo getContactInfo() {
		if (contactInfo == null) {
			initContactInfo();
		}
		return contactInfo;
	}

	private void initContactInfo() {
		contactInfo = new ContactInfo();
    	contactInfo.setRegInfo(new RegInfo());
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public List<Activity> getActivities() {
		if (activities == null) activities = registrationService.getActivities();
		return activities;
	}

	public BigDecimal getActivityId() {
		return activityId;
	}

	public void setActivityId(BigDecimal activityId) {
		this.activityId = activityId;
	}
}

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

	private BigDecimal countryId = BigDecimal.ZERO;  // select the first option in the combo
    private BigDecimal cityId = BigDecimal.ZERO;    // select the first option in the combo
    private List<Country> countries;
    private List<City> cities;

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
}

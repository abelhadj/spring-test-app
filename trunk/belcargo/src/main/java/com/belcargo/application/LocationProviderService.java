package com.belcargo.application;

import java.math.BigDecimal;
import java.util.List;

import com.belcargo.model.lut.City;
import com.belcargo.model.lut.Country;
import com.belcargo.model.lut.Region;


public interface LocationProviderService {

	public List<Country> getCountries();
	public void getRegions(Country country);
	public void getCities(Country country, Region region);
	public List<City> getCities(BigDecimal countryId);
}

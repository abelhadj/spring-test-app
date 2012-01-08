package com.belcargo.repositories;

import java.math.BigDecimal;
import java.util.List;

import com.belcargo.model.lut.City;
import com.belcargo.model.lut.Country;
import com.belcargo.model.lut.Region;

public interface LocationDAO {
	public List<Country> getCountries();
	public List<Region> getRegions(Country country);
	public List<City> getCities(Country country, Region region);
	public List<City> getCities(BigDecimal countryId);
}

package com.belcargo.application.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.belcargo.application.LocationProviderService;
import com.belcargo.model.lut.City;
import com.belcargo.model.lut.Country;
import com.belcargo.model.lut.Region;
import com.belcargo.repositories.LocationDAO;

@Service("locationService")
public class LocationProviderServiceImpl implements LocationProviderService {
	@Resource(name="locationRepository")
	private LocationDAO locationRepository;

	public void setLocationRepository(LocationDAO locationRepository) {
		this.locationRepository = locationRepository;
	}

	@Override
	public List<Country> getCountries() {
		return locationRepository.getCountries();
	}

	@Override
	public void getRegions(Country country) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getCities(Country country, Region region) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<City> getCities(BigDecimal countryId) {
		return locationRepository.getCities(countryId);
	}

}

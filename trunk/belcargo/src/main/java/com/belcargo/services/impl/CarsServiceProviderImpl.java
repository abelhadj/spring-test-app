package com.belcargo.services.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.belcargo.model.Car;
import com.belcargo.repositories.CarsDAO;
import com.belcargo.services.CarsServiceProvider;

@Service("carsDataProvider")
public class CarsServiceProviderImpl implements CarsServiceProvider, Serializable {
	private static final long serialVersionUID = 1260303793634296074L;
	
	@Resource(name="carsRepository")
	private CarsDAO carsRepository;
	
	@Override
	public List<Car> getCars() {
		return carsRepository.getCars();
	}

	public void setCarsRepository(CarsDAO carsRepository) {
		this.carsRepository = carsRepository;
	}
}

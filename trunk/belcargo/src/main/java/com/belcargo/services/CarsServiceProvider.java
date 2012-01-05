package com.belcargo.services;

import java.util.List;

import com.belcargo.model.Car;

public interface CarsServiceProvider {

//	@RolesAllowed({"ROLE_ADMIN","ROLE_REGISTERED"})
	public abstract List<Car> getCars();
}

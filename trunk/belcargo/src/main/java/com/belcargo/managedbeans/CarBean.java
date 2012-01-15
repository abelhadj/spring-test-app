package com.belcargo.managedbeans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.belcargo.model.Car;
import com.belcargo.services.CarsServiceProvider;

@ManagedBean(name="carBean")
@SessionScoped
public class CarBean implements Serializable {
	private static final long serialVersionUID = 89574332234408210L;

	@ManagedProperty("#{carsDataProvider}")
	private CarsServiceProvider carsDataProvider;

	private Car car;
	private BigDecimal carId;

//	public void save() {
//		carsDataProvider.saveCar(car);
//	}
//
//	public void load() {
//		car = carsDataProvider.loadCarById(carId);
//	}

	public void setCarsDataProvider(CarsServiceProvider carsDataProvider) {
		this.carsDataProvider = carsDataProvider;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public BigDecimal getCarId() {
		return carId;
	}

	public void setCarId(BigDecimal carId) {
		this.carId = carId;
	}

}

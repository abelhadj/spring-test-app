package com.belcargo.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.belcargo.model.Car;
import com.belcargo.services.CarsServiceProvider;

@ManagedBean(name="carsListBean")
@SessionScoped
public class CarsList implements Serializable {


	private static final long serialVersionUID = 8957439343830408210L;

	@ManagedProperty("#{carsDataProvider}")
	private CarsServiceProvider carsDataProvider;

	private List<Car> carsList;
//	public List<Car> getCarsList(){
//		carsList = new ArrayList<Car>();
//		Car car = new Car();
//		car.setName("asdfdf");
//		Country countryFrom = new Country();
//		countryFrom.setName("Belarus");
//		carsList.add(car);
//		carsList.add(car);
//		carsList.add(car);
//		return carsList;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setCarsDataProvider(CarsServiceProvider carsDataProvider) {
        this.carsDataProvider = carsDataProvider;
    }

	public void setCarsList(List<Car> carsList) {
		this.carsList = carsList;
	}

	public List<Car> getCarsList(){
		if (carsList == null) {
			carsList = carsDataProvider.getCars();
		}
		return carsList;
	}
}

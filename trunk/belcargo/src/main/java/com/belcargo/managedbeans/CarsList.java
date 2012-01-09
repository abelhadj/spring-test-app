package com.belcargo.managedbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.belcargo.model.Car;
import com.belcargo.services.CarsServiceProvider;

@ManagedBean(name="carsListBean")
@SessionScoped
public class CarsList implements Serializable {
	private static final long serialVersionUID = 8957439343830408210L;

	@ManagedProperty("#{carsDataProvider}")
	private CarsServiceProvider carsDataProvider;

	private List<Car> carsList;
	private Integer currentCarId;
	private Boolean showCarDescrPopup;

	public CarsList() {
		showCarDescrPopup = false;
	}

	public String showForm () {
		return "register.xhtml";
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CarsServiceProvider getCarsDataProvider() {
		return carsDataProvider;
	}

	public Car getCurrentCar() {
		Car car = (getCurrentCarId() == null) ? null :
					getCarsList().get(getCurrentCarId());
		currentCarId = null;
		return car;
	}

	public Integer getCurrentCarId() {
		if (currentCarId == null) {
			FacesContext context = FacesContext.getCurrentInstance();
	        Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
	        try {
	        	currentCarId = Integer.parseInt(paramMap.get("id"));
	        } catch (NumberFormatException e) {
	        	currentCarId = null;
	        }
		}
		return currentCarId;
	}

	public void setCurrentCarId(Integer currentCarId) {
		this.currentCarId = currentCarId;
		setShowCarDescrPopup(true);
	}

	public Boolean getShowCarDescrPopup() {
		return showCarDescrPopup;
	}

	public void setShowCarDescrPopup(Boolean showCarDescrPopup) {
		this.showCarDescrPopup = showCarDescrPopup;
	}
}

package com.belcargo.application;

import java.util.List;

import com.belcargo.model.lut.Activity;


public interface RegistrationService {

	public void registerUser(String username, String password);
	public List<Activity> getActivities();
}

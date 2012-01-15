package com.belcargo.application.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.belcargo.application.RegistrationService;
import com.belcargo.model.lut.Activity;
import com.belcargo.repositories.AccountDAO;
import com.belcargo.repositories.ActivityDAO;

@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {
	@Resource(name="accountRepository")
	private AccountDAO personRepository;
	@Resource(name="activityRepository")
	private ActivityDAO activityRepository;

	@Override
	@Transactional
	public void registerUser(String userName, String password) {
		getPersonRepository().registerUser(userName, encodeMD5(password), "ROLE_REGISTERED");
	}

	@Override
	public List<Activity> getActivities() {
		return getActivityRepository().getActivities();
	}

	public String encodeMD5(String password) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			LoggerFactory.getLogger(getClass()).error("Cannot find MessageDigest", e);
		}
		messageDigest.update(password.getBytes(),0, password.length());
		String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);
		if (hashedPass.length() < 32) {
		   hashedPass = "0" + hashedPass;
		}
		return hashedPass;
	}

	public ActivityDAO getActivityRepository() {
		return activityRepository;
	}

	public void setActivityRepository(ActivityDAO activityRepository) {
		this.activityRepository = activityRepository;
	}

	public AccountDAO getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(AccountDAO personRepository) {
		this.personRepository = personRepository;
	}
}

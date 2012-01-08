package com.belcargo.application.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.belcargo.application.RegistrationService;
import com.belcargo.repositories.AccountDAO;

@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {
	@Resource(name="accountRepository")
	private AccountDAO personRepository;

	public AccountDAO getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(AccountDAO personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	@Transactional
	public void registerUser(String userName, String password) {
		getPersonRepository().registerUser(userName, encodeMD5(password), "ROLE_REGISTERED");
	}

	public String encodeMD5(String password) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			Logger.getLogger(getClass()).error("Cannot find MessageDigest", e);
		}
		messageDigest.update(password.getBytes(),0, password.length());
		String hashedPass = new BigInteger(1,messageDigest.digest()).toString(16);
		if (hashedPass.length() < 32) {
		   hashedPass = "0" + hashedPass;
		}
		return hashedPass;
	}
}

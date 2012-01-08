package com.belcargo.repositories;

import com.belcargo.model.Account;

public interface AccountDAO {

	public Account getAccountByLogin(String login);
	public void registerUser(String userName, String password, String roleName);
}

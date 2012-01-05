package com.belcargo.repositories;

import com.belcargo.model.Person;

public interface PersonDAO {

	public Person getPersonByLogin(String login);
}

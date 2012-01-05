package com.belcargo.repositories.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.belcargo.model.Person;
import com.belcargo.repositories.PersonDAO;

@Repository("PersonRepository")
public class PersonDAOImpl implements PersonDAO {
	
	private EntityManager em = null;
    
	/**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@Override
	public Person getPersonByLogin(String login) {
		Query query = em.createQuery("from Person p where p.login = :login");
		query.setParameter("login", login);
        return (Person) query.getSingleResult();
	}

}

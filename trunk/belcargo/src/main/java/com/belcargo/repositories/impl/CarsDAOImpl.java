package com.belcargo.repositories.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.belcargo.model.Car;
import com.belcargo.repositories.CarsDAO;

@Repository("carsRepository")
public class CarsDAOImpl implements CarsDAO, Serializable {
	
	@PersistenceContext
	private EntityManager em = null;

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> getCars() {
		String sqlQuery = "from Car";
		return em.createQuery(sqlQuery).getResultList();
	}
}

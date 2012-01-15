package com.belcargo.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.belcargo.model.lut.Activity;
import com.belcargo.repositories.ActivityDAO;

@Repository("activityRepository")
public class ActivityDAOImpl implements ActivityDAO {
	private EntityManager em = null;

	/**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> getActivities() {
		Query query = em.createQuery("from Activity");
        return query.getResultList();
	}
}

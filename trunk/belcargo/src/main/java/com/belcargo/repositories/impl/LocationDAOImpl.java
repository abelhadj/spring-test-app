package com.belcargo.repositories.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.belcargo.model.Account;
import com.belcargo.model.lut.City;
import com.belcargo.model.lut.Country;
import com.belcargo.model.lut.Region;
import com.belcargo.repositories.LocationDAO;

@Repository("locationRepository")
public class LocationDAOImpl implements LocationDAO {

	private EntityManager em = null;

	/**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	public Account getAccountByLogin(String login) {
		Query query = em.createQuery("from Account a where a.login = :login");
		query.setParameter("login", login);
        return (Account) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Country> getCountries() {
		Query query = em.createQuery("from Country where id >= 999 order by name");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Region> getRegions(Country country) {
		Query query = em.createQuery("from Region a where a.country.id = :countryId");
		query.setParameter("countryId", country.getId());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> getCities(Country country, Region region) {
		Query query = em.createQuery("from Region a where a.country.id = :countryId and a.region.id = :regionId order by name");
		query.setParameter("countryId", region.getCountry().getId());
		query.setParameter("regionId", region.getId());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> getCities(BigDecimal countryId) {
		Query query = em.createQuery("from City c where c.country.id = :countryId order by name");
		query.setParameter("countryId", countryId);
		return query.getResultList();
	}
}


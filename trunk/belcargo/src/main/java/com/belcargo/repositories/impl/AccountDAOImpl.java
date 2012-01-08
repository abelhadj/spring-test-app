package com.belcargo.repositories.impl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.belcargo.model.Account;
import com.belcargo.model.Role;
import com.belcargo.repositories.AccountDAO;
import com.belcargo.utils.WebUtils;

@Repository("accountRepository")
public class AccountDAOImpl implements AccountDAO {

	private EntityManager em = null;

	/**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@Override
	public Account getAccountByLogin(String login) {
		Query query = em.createQuery("from Account a where a.login = :login");
		query.setParameter("login", login);
        return (Account) query.getSingleResult();
	}

	@Override
	public void registerUser(String userName, String password, String roleName) {
		Query query = em.createQuery("from Account r where r.login = :login");
		query.setParameter("login", userName);
		Account existingAcc = (Account) query.getSingleResult();

		if (existingAcc == null) {
			query = em.createQuery("from Role r where r.roleName = :roleName");
			query.setParameter("roleName", roleName);
			Role role = (Role) query.getSingleResult();

			Account account = new Account(userName, password, role);
			em.merge(account);
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Login already exists."));
			WebUtils.addFacesMessage("login err");
		}
	}

}

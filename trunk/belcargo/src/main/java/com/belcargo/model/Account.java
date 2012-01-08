package com.belcargo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="ACCOUNT")
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ACCOUNT_PK")
	private Integer accountId;
	@OneToOne
	@JoinColumn(name="ROLE_FK")
	private Role currentRole;
	@Column(name="LOGIN")
	private String login;
	@Column(name="PASSWORD")
	private String password;

	public Account() {
	}

	public Account(String username, String password, Role role) {
		this.login = username;
		this.password = password;
		this.currentRole = role;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Role getCurrentRole() {
		return currentRole;
	}
	public void setCurrentRole(Role currentRole) {
		this.currentRole = currentRole;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}

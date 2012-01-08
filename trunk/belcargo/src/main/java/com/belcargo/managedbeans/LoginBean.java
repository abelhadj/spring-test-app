package com.belcargo.managedbeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.belcargo.application.AuthenticationService;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String login;
	private String password;

	@ManagedProperty(value = "#{authenticationService}")
	private AuthenticationService authenticationService; // injected Spring defined service for books


	public String login() {

		boolean success = authenticationService.login(login, password);

		if (success){
			return "booksLibrary"; // return to application but being logged now
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Wrong login or password"));
			return "login.xhtml";
		}
	}

   public String logout() {
       authenticationService.logout();
       return "login.xhtml?faces-redirect=true";
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

	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}
}

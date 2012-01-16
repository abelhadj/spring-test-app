package com.belcargo.application.impl;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.belcargo.application.AuthenticationService;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService, Serializable {
	private static final long serialVersionUID = 803721195270022922L;

	@Resource(name = "authenticationManager")
	private AuthenticationManager authenticationManager; // specific for Spring Security

	@Override
	public boolean login(String username, String password) {
		try {
			Authentication authenticate = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(
							username, password));
			if (authenticate.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(
						authenticate);
				return true;
			}
		} catch (AuthenticationException e) {
		    LoggerFactory.getLogger(getClass()).error("AuthenticationException" , e);
		}
		return false;
	}

	@Override
	public void logout() {
		SecurityContextHolder.getContext().setAuthentication(null);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		if (session != null) {
		    session.invalidate();
		}
	}


}

package com.belcargo.application.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;
import javax.persistence.NoResultException;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.belcargo.model.Person;
import com.belcargo.repositories.PersonDAO;

/*
 * Spring-security requires an implementation of UserDetailService. 
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService, Serializable {
	
	private static final long serialVersionUID = 6990374747017039754L;
	
	@Resource(name="PersonRepository")
	private PersonDAO personRepository;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException{
		
		try {
			
			Person p = personRepository.getPersonByLogin(username);					
			
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			
			Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			grantedAuthorities.add(new GrantedAuthorityImpl(p.getCurrentRole().getRoleName())); // RoleName = "ROLE_ADMIN" or "ROLE_REGISTERED"
			
			
			org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(p.getLogin(), p.getPassword(), enabled, accountNonExpired,
					credentialsNonExpired, accountNonLocked, grantedAuthorities);
			
			return user;
			
		} catch (NoResultException e) {
			throw new UsernameNotFoundException("No such user");
		}
			
	}

}

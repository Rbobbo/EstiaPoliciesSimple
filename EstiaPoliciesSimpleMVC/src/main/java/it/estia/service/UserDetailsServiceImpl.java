package it.estia.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import it.estia.entity.dao.UserDAO;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	
	UserDAO userDaoImpl;

	public UserDAO getUserDaoImpl() {
		return userDaoImpl;
	}

	public void setUserDaoImpl(UserDAO userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		
		User springUser = buildUserForAuthentication(username);
		
		return springUser;
	}
	
	private User buildUserForAuthentication(String username)
	{
		it.estia.entity.User userLocal = userDaoImpl.getUser(username);
		if( userLocal == null )
		{
			userLocal = new it.estia.entity.User();
		}
		
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		setAuths.add(new SimpleGrantedAuthority(userLocal.getRole()));
		List<GrantedAuthority> authorities = new ArrayList<>(setAuths);
		
		return new User(userLocal.getLogincode(), userLocal.getLoginpassword(),  authorities);
	}
	
	
	

}
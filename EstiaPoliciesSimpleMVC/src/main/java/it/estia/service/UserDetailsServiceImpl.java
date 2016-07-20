package it.estia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

	private User userDao;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		
		User springUser = buildUserForAuthentication();
		
		return springUser;
		

	}
	
	private User buildUserForAuthentication()
	{
		List<GrantedAuthority> authorities = new ArrayList<>();
		return new User("prova1", "password1",  authorities);
	}
	
	
	

}
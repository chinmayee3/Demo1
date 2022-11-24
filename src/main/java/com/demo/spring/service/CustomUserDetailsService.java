package com.demo.spring.service;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if(username.equals("admin"))
		{
			return new User("admin","admin123",new ArrayList<>());
		}else
		{
			throw new UsernameNotFoundException("User not found!");
		}
		
	}
	
}

package com.myself.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myself.model.User;
import com.myself.repository.UserRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		CustomerUserDetails userDetails;
		if (user != null) {
			userDetails = new CustomerUserDetails();
			userDetails.setUser(user);
	}else {
		throw new UsernameNotFoundException("User not exist with name : " + username);
	}
		return userDetails;
}
}

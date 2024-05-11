package com.loginregistration.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.loginregistration.entity.User;
import com.loginregistration.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
	
	private UserRepository userRepository;
	 public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user= userRepository.findByUsername(username).orElseThrow(() ->
        new UsernameNotFoundException("User not found with username : "+ username));
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassward(), null);
	}

}

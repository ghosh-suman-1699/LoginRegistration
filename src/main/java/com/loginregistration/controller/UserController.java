package com.loginregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginregistration.dto.LoginDto;
import com.loginregistration.dto.RegistrationDto;
import com.loginregistration.entity.User;
import com.loginregistration.repository.UserRepository;

@RestController
@RequestMapping("/api/user")

public class UserController {
	
	 @Autowired
	 private AuthenticationManager authenticationManager;
	 
	 
	 @Autowired
	 private UserRepository userRepository;
	 
	 @Autowired
	    private PasswordEncoder passwordEncoder;
		 
	 @PostMapping("/login")
	 public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
		 Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
		 
		 SecurityContextHolder.getContext().setAuthentication(authentication);
	        return new ResponseEntity<>("User login-in successfully!.", HttpStatus.OK);
	 }
	 
	 @PostMapping("/registration")
	    public ResponseEntity<?> registerUser(@RequestBody RegistrationDto registrationDto){
		 
		 // add check for username exists in a DB
	        if(userRepository.existsByUsername(registrationDto.getUsername())){
	            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
	        }
	      
	     // create user object
	        User user = new User();
	        user.setName(registrationDto.getName());
	        user.setUsername(registrationDto.getUsername());
	        user.setPassward(passwordEncoder.encode(registrationDto.getPassword()));
	        
	        userRepository.save(user);
	        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
	 }

}

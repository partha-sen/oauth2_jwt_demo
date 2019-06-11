package com.codinggate.auth.dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.codinggate.auth.model.AppUserPrincipal;
import com.codinggate.auth.model.User;

@Component
public class UserDaoImpl implements UserDao{
	
	Map<String, User> hm=new HashMap<>();
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@PostConstruct
	public void init(){
		
		User u1=new User();
		u1.setUsername("sukesh@epam.com");
		u1.setPassword(passwordEncoder.encode("password"));
		u1.setRoles(Arrays.asList("admin"));		
		hm.put(u1.getUsername(), u1);
		
		User u2=new User();
		u2.setUsername("partha@epam.com");
		u2.setPassword(passwordEncoder.encode("password"));
		u2.setRoles(Arrays.asList("user"));		
		hm.put(u2.getUsername(), u2);
		
	}
	

	@Override
	public Optional<UserDetails> getUserById(String userId) {		
		System.out.println("getUserById called ......");
		return Optional.ofNullable(new AppUserPrincipal(hm.get(userId)));  
	}
	
}

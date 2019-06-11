package com.codinggate.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codinggate.auth.dao.UserDao;

@Service
public class CodinggateUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserDao userDao;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
    	return userDao.getUserById(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found"));
    }
}
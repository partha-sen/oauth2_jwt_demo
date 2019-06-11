package com.codinggate.auth.dao;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDao {
   public Optional<UserDetails> getUserById(String userId);
}

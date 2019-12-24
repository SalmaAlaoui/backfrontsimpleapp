package com.coding.challenge.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.coding.challenge.Model.User;
import com.coding.challenge.dto.UserRegistrationDto;
@Service
public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);

}

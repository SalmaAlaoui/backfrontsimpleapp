package com.coding.challenge.Controller;

import com.coding.challenge.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coding.challenge.Model.User;

@CrossOrigin()
@RestController
@RequestMapping({ "/users" })
public class UserController {
	@Autowired
  private UserRepository userrep;

	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public User validateLogin() {

		return new User("User successfully authenticated");
	}



}



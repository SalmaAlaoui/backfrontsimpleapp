package com.coding.challenge.Controller;

import com.coding.challenge.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

import com.coding.challenge.Model.Role;
import com.coding.challenge.Model.User;

@CrossOrigin()
@RestController
@RequestMapping({ "/users" })
public class UserController {
	@Autowired
  private UserRepository userrep;
  @Autowired
  private RoleRepository rolerep;

	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public User validateLogin() {

		return new User("User successfully authenticated");
	}




@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;

  @PostMapping
  public User create(@RequestBody User user) {

      String pass= user.getPassword();
      String newpass = bCryptPasswordEncoder.encode(pass);
      user.setPassword(newpass);
      Set<Role> roles1 = new HashSet<Role>();
      roles1.add(rolerep.findByRole("ROLE_USER"));
      user.setRoles(roles1);
      userrep.save(user);

      return user;
  }

}



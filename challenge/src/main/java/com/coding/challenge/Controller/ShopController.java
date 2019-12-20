package com.coding.challenge.Controller;

import com.coding.challenge.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin()
@RestController
@RequestMapping({ "/shops" })
public class ShopController {
	@Autowired
  private ShopRepository shoprep;




}

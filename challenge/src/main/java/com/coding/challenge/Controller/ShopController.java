package com.coding.challenge.Controller;

import java.util.List;

import com.coding.challenge.Model.Shop;
import com.coding.challenge.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin()
@RestController
@RequestMapping({ "/shops" })
public class ShopController {
	@Autowired
  private ShopRepository shoprep;



  @GetMapping(produces = "application/json")
  public List<Shop> firstPage() {
      List<Shop> shops = shoprep.findAll();
      return shops;
  }



  @PostMapping
  public Shop create(@RequestBody Shop shop) {

      shoprep.save(shop);

      return shop;
  }

}

package com.coding.challenge.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coding.challenge.Controller.dao.*;
import com.coding.challenge.Model.Shop;
import com.coding.challenge.Pagination.*;
import com.coding.challenge.Controller.dao.UserRepository;

@Controller
public class MainController {

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

    @Autowired
    ShopsDAO shopsdao;
    @RequestMapping({ "/Shopslist" })
   public String listProductHandler(Model model, //
         @RequestParam(value = "name", defaultValue = "") String likeName,
         @RequestParam(value = "page", defaultValue = "1") int page) {
      final int maxResult = 5;
      final int maxNavigationPage = 10;



      PaginationResult<Shop> result = shopsdao.queryProducts(page,maxResult,maxNavigationPage,likeName);

      model.addAttribute("paginationProducts", result);
      return "productList";
   }
}

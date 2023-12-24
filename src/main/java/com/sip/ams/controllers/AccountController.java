package com.sip.ams.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sip.ams.entities.User;
import com.sip.ams.services.AccountService;

@Controller
@RequestMapping("/accounts/")

public class AccountController {

	
	private final AccountService accountService;
	
	@Autowired
    public AccountController(AccountService accountService) {
        this.accountService =  accountService;
    }
	
	@GetMapping("list")
    public String listUsers(Model model) {
    	
    	List<User> users = (List<User>)  accountService.listUsers();
    	long nbr =  accountService.listUsers().size();
    	if(users.size()==0)
    		users = null;
        model.addAttribute("users", users);
        model.addAttribute("nbr", nbr);
        return "user/listUsers";
    }
    
    
}

package com.sip.ams.controllers;

import com.sip.ams.entities.User;
import com.sip.ams.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

@RequestMapping("/registration")
public class RegisterController {


	@Autowired
	private  UserService userService;
  

    @GetMapping("")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("")
    public String Register(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/home";
    }
    
  

}

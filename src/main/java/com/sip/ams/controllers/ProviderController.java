package com.sip.ams.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.Provider;
import com.sip.ams.services.ProviderService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/providers")
public class ProviderController {
	
	@Autowired  //injection de dépendances
	ProviderService service ;//= new ProviderService();
	
	
	
	@RequestMapping("/list")
	@ResponseBody
	public String list() {
		List<Provider> res = service.listProvider();
		return res.toString();
	}
	
	@GetMapping("add")
    public String showAddProviderForm(Model model) {
    	Provider provider = new Provider();// object dont la valeur des attributs par defaut
    	model.addAttribute("provider", provider);
        return "provider/addProvider";
    }
    
    @PostMapping("add")
    public String addProvider(@Valid Provider provider, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "provider/addProvider";
        }
        service.addProvider(provider);
        return "redirect:list";
    }


}

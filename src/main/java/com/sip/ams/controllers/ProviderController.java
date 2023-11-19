package com.sip.ams.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.Provider;
import com.sip.ams.services.ProviderService;

@Controller
@RequestMapping("/providers")
public class ProviderController {
	
	@Autowired  //injection de dépendances
	ProviderService service ;//= new ProviderService();
	
	@RequestMapping("/add")
	@ResponseBody
	public String add()
	{
		//Provider p1 = new Provider("Samsung","Koré SUD","samsung@hotmail.com");
		//Provider res = service.addProvider(p1);
		
		Provider p2 = new Provider("HP","USA","hp@hotmail.com");
		Provider res =service.addProvider(p2);
		return res.toString();
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public String list() {
		List<Provider> res = service.listProvider();
		return res.toString();
	}

}

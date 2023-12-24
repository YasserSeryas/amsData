package com.sip.ams.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.User;
import com.sip.ams.repositories.UserRepository;

@Service
public class AccountService {
	
	@Autowired  // Spring va se charger de créer un objet qui implémente cette interface
	UserRepository userRepository ;
	
	public List<User> listUsers()
	{
		return (List<User>) userRepository.findAll();	 // lister tous les roles de la base
	}

}

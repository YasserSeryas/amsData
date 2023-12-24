package com.sip.ams.services;

import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.sip.ams.controllers.HashSet;
//import com.sip.ams.controllers.Role;
import com.sip.ams.entities.Role;
import com.sip.ams.entities.User;
import com.sip.ams.repositories.RoleRepository;
import com.sip.ams.repositories.UserRepository;

@Service
public class AccountService {
	
	@Autowired  // Spring va se charger de créer un objet qui implémente cette interface
	UserRepository userRepository ;
	@Autowired
	RoleRepository roleRepository;
	
	public List<User> listUsers()
	{
		return (List<User>) userRepository.findAll();	 // lister tous les roles de la base
	}

	
	
	public User enableAccount(int id)
	{
		 User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid User Id:" + id));
	     user.setActive(1);
	     return userRepository.save(user);
	}
	
	public User disableAccount(int id)
	{
		 User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid User Id:" + id));
	     user.setActive(0);
	     return userRepository.save(user);
	}
	
	public Optional<User> findById(int id) {
		return userRepository.findById(id);

	}

	public User save(User user) {
		return userRepository.save(user);
		
	}



	public void updateRole(int id, String newRole) {
		User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid User Id:" + id));
	     
		 Role userRole = roleRepository.findByRole(newRole);
		 
	     user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
	     
	     userRepository.save(user);
		
	}

}

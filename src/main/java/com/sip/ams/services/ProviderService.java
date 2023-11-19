package com.sip.ams.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ProviderRepository;

@Service
public class ProviderService {
	
	@Autowired  // Spring va se charger de créer un objet qui implémente cette interface
	ProviderRepository providerRepository ;
	
	
	public Provider addProvider(Provider provider)
	{
		return providerRepository.save(provider);  // sauvegarder dans la base
		
	}
	
	public List<Provider> listProvider()
	{
		return (List<Provider>) providerRepository.findAll();	 // lister tous les providers de la base
	}

}

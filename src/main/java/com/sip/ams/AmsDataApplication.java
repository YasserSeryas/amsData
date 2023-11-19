package com.sip.ams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sip.ams.entities.Provider;
import com.sip.ams.services.ProviderService;

@SpringBootApplication
public class AmsDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmsDataApplication.class, args);
		
	}

}

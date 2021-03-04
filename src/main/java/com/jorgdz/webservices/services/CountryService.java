package com.jorgdz.webservices.services;

import io.spring.guides.gs_producing_web_service.Country;

public interface CountryService {
	
	Country findByName (String name);
}

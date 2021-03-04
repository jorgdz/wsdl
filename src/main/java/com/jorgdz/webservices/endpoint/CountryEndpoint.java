package com.jorgdz.webservices.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.jorgdz.webservices.services.CountryService;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;

@Endpoint
public class CountryEndpoint {
	
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	
	@Autowired
	private CountryService serviceCountry;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest req) {
		GetCountryResponse response = new GetCountryResponse();
		
		Country country = this.serviceCountry.findByName(req.getName());
		response.setCountry(country);
		
		System.out.println(response.getCountry().getCapital());
		
		return response;
	}
}

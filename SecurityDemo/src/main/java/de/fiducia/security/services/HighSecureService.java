package de.fiducia.security.services;

import org.springframework.security.access.annotation.Secured;

public interface HighSecureService {

	
	void secureServicesMethodFoo();

	void secureServicesMethodBar();

}
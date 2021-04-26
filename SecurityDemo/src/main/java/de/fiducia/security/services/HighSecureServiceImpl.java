package de.fiducia.security.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class HighSecureServiceImpl implements HighSecureService {
	
	private static final Logger logger = LoggerFactory.getLogger(HighSecureServiceImpl.class);
	 
	
	@Override
	
	@Secured("ROLE_USER")
	public void secureServicesMethodFoo() {
		logger.warn("secureServicesMethodFoo called");
		System.out.println("OK");
		
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    System.out.print( "Current User Authorities inside this RunAS method only " + 
	          auth.getAuthorities().toString());
	}

	@Override
	@Secured("ROLE_USER")
	public void secureServicesMethodBar() {
		logger.warn("secureServicesMethodBar called");
	}

}

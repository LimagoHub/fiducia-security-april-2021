package de.fiducia.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unsecure")
public class UnsecuredController {
	
	
	@GetMapping("/notsafe")
	public String notSafe() {
		return "i am not safe";
	}

}

package de.fiducia.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecurityDemoApplication {

	public static void main(final String[] args) {
		final String password = "password";
		final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		final String hashedPassword = passwordEncoder.encode(password);

		System.out.println(hashedPassword);
		
		System.out.println(passwordEncoder.matches("password", "$2a$10$okpMatjfDqh8TXmXMYWsrekYD2hSrOtiNXU4qXfmZmTW7nV3hM2Am"));
		SpringApplication.run(SecurityDemoApplication.class, args);
	}

}

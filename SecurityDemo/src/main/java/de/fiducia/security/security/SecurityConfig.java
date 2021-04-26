package de.fiducia.security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.intercept.RunAsImplAuthenticationProvider;
import org.springframework.security.access.intercept.RunAsManager;
import org.springframework.security.access.intercept.RunAsManagerImpl;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final UserRepository userRepository;

	public SecurityConfig(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/home").permitAll()
				.antMatchers("/unsecure/*").permitAll()
				.antMatchers("/secure/*").hasRole("USER")
				.anyRequest().authenticated()
			
				.and()
				
			.formLogin()
				.and()
			.logout()
				.permitAll();
	}
	
	@Bean 
    @Override
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findById(username).orElseThrow(()->new UsernameNotFoundException(username));
	}


//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		final UserDetails user =
//			 User //.withDefaultPasswordEncoder()
//			 
//				.withUsername("user")
//				.password("$2a$10$t6xNCf1ALLobFP64tTvAMel.dggwFqZ8wgbWNfDuIvJKFESc2jsy6")
//				.roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
			    
			

		    
	
}

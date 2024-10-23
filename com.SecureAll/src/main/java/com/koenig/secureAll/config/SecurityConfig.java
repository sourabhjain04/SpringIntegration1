package com.koenig.secureAll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	// Creating Configured userName and password through beans
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("geofrey")
				.password("geofrey123")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
	
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		
		return (web)-> web.ignoring().requestMatchers("/home","/contact");
		
	}

}

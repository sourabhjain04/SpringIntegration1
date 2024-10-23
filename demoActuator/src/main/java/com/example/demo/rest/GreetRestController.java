package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {

	@GetMapping("/greet")
	public String greetMsg() {
		
		return "good Afternoon";
	}
	

	@GetMapping("/welcome")
	public String welcomeMsg() {
		
		return "Welcome to Koenig";
	}
}

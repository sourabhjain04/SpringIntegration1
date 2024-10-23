package com.koenig.secureAll.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/home")
	public String home() {
		String msg = "Welcome to bank";
		return msg;
		
	}
	@GetMapping("/balance")
	public String getBalance() {
		String msg = "your current balance is 5000";
		return msg;
		
	}
	@GetMapping("/statement")
	public String getStmt() {
		String msg = "Your Statement is sent to your email is";
		return msg;
	}
	
	@GetMapping("/loan")
	public String getMyLoan() {
		String msg = "your loan amount due is 50000";
		return msg;
		
	}
	@GetMapping("/contact")
	public String contact() {
		String msg = "In grugram,India";
		return msg;
		
	}
	

}

package com.koenig.secure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	@GetMapping("/Welcome")
	public String getmsg() {
		String msg = "Welcome to Koenig";
		return msg;
	}
}

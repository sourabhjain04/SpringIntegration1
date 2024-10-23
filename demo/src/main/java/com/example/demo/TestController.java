package com.example.demo;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.function.ServerRequest.Headers;

@Controller
public class TestController {
	 @GetMapping("/plain-text")
	    public String getPlainText() {
	        return "This is plain text!";
		
	}
}

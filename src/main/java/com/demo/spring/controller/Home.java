package com.demo.spring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Home {
	
	@CrossOrigin(origins = "*", allowedHeaders = "*") 
	@RequestMapping("/welcome")
	public String welcome() {
		String text="this is private page";
		text +="this page is not allowed";
		return text;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*") 
	@RequestMapping("/getusers")
	public String getUser() {
		return "{\"name\" : \"Admin\"}";
	}
	
	

}

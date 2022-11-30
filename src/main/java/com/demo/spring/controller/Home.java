package com.demo.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.model.Student;
import com.demo.spring.service.EmailService;
import com.demo.spring.service.StudentService;

@CrossOrigin("*")
@RestController
public class Home {
	/*
	@RequestMapping("/welcome")
	public String welcome() {
		String text="this is private page";
		text +="this page is not allowed";
		return text;
	}
	
	
	@GetMapping("/getusers")
	public String getUser() {
		return "{\"name\" : \"Admin\"}";
	}
	*/
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/getall")
	public List<Student> getAll()
	{
		return this.studentService.getAllStudents();
	}
	
    @GetMapping("/sendmail")
	//@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() {
    	System.out.println("Hiiiiiiiiiiiiiiiiii");
    	this.studentService.sendMail();
    
    }

	
	

}

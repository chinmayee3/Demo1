package com.demo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.model.Student;
import com.demo.spring.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	/*
	@GetMapping("/getall")
	public List<Student> getAll()
	{
		return this.studentService.getAllStudents();
	}
	*/
	

}

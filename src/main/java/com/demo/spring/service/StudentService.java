package com.demo.spring.service;

import java.util.List;

import com.demo.spring.model.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	
	void sendMail();

}

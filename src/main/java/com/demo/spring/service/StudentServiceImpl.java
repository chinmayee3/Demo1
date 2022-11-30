package com.demo.spring.service;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.demo.spring.repository.StudentRepository;
import com.demo.spring.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmailService emailService;
	List<Student> defaulter_list=new ArrayList();
	
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		//create list and store only whose att is less than 75
		float att_cnt=20.0f;
		List<Student> original_list=studentRepository.findAll();
		
		
		for(int i=0;i<original_list.size();i++)
		{
			Student std=original_list.get(i);
			float perct=(std.getAttendance()/att_cnt)*100;
			System.out.println(perct+"\n");
			if(perct<75)
			{
				defaulter_list.add(std);
			}
		}
		System.out.println(defaulter_list);
		return defaulter_list;
	}

	@Override
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		// TODO Auto-generated method stub
		//defaulter_list=this.getAllStudents();
		for(int i=0;i<defaulter_list.size();i++)
		{
			ArrayList<String> emails = new ArrayList<String>();
			String x=defaulter_list.get(i).getEmail();
			emails.add(x);
			emailService.sendSimpleEmail("akankshadhage78@gmail.com",
					emails,
					"This is for college work plz ignore",
					"Project");
			
		}
			
	}
	
	

}

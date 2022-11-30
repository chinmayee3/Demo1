package com.demo.spring.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendSimpleEmail(String fromEmail, ArrayList<String> toEmail, String body, String subject) {
	
		for(int i=0;i < toEmail.size();i++) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setFrom("akankshadhage30072001@gmail.com");
		mailMessage.setTo(toEmail.get(i));
		mailMessage.setSubject(subject);
		mailMessage.setText(body);
		
		javaMailSender.send(mailMessage);
		System.out.println("Mail Send..." + toEmail.get(i));
		}
	}

}

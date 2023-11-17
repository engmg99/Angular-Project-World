package com.projectworld.ProjectWorld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectworld.ProjectWorld.entity.EmailRequest;
import com.projectworld.ProjectWorld.services.EmailApiService;

@RestController
@RequestMapping(value = "/email/")
public class EmailController {

	@Autowired
	private EmailApiService emailService;

	@PostMapping("/sendEmail")
	public String emailRequestData(@RequestBody EmailRequest emailData) {
		System.out.println(emailData);
		String message = emailData.getMessage();
		String subject = emailData.getSubject();
		String to = emailData.getTo();
		// emailService.sendEmail(message,subject,to);
		return "success";
	}

	@GetMapping("/send")
	public String sendEmail() {
		String message = "Hello , Dear, this is message for security check . ";
		String subject = "CodersArea : Confirmation";
		String to = "goyalmunish4306@gmail.com";
		emailService.sendEmail(message, subject, to);
		return "success";
	}

	// apply validation in angular
}

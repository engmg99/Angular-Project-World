package com.projectworld.ProjectWorld.controller;

import com.projectworld.ProjectWorld.entity.EmailRequest;
import com.projectworld.ProjectWorld.services.EmailApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/email/")
public class EmailController {

    @Autowired
    private EmailApiService emailService;

    @PostMapping("/sendEmail")
    public String emailRequestData(@RequestBody EmailRequest emailData){
        System.out.println(emailData);
        String message = emailData.getMessage();
        String subject =emailData.getSubject();
        String to = emailData.getTo();
        //emailService.sendEmail(message,subject,to);
        return "success";
    }

    @GetMapping("/send")
    public String sendEmail(){
        String message = "Hello , Dear, this is message for security check . ";
        String subject = "CodersArea : Confirmation";
        String to = "goyalmunish4306@gmail.com";
        emailService.sendEmail(message,subject,to);
        return "success";
    }

    // apply validation in angular
}


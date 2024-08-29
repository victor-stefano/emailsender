package com.example.emailsender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.emailsender.model.EmailRequest;
import com.example.emailsender.service.EmailService;

import jakarta.mail.MessagingException;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody EmailRequest request) {
    	try {    		
    		emailService.sendEmail(request.getFrom(), request.getTo(), request.getSubject(), request.getText());
    		return "Email enviado com sucesso!";
    	} catch (MessagingException e) {
    		return "Ocorreu um erro ao tentar enviar o email.";
    	}
    }
}

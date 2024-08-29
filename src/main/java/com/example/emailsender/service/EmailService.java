package com.example.emailsender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String from, String to, String subject, String text) throws MessagingException {
    	MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);
        
        ClassPathResource imageLogo = new ClassPathResource("static/assets/logo.png");
        helper.addInline("logo", imageLogo);

        ClassPathResource imageSticker = new ClassPathResource("static/assets/sticker.png");
        helper.addInline("sticker", imageSticker);

        ClassPathResource imageCoin = new ClassPathResource("static/assets/coin.png");
        helper.addInline("coin", imageCoin);
        
        ClassPathResource imageWelcome = new ClassPathResource("static/assets/welcome.png");
        helper.addInline("welcome", imageWelcome);
        
        javaMailSender.send(message);
    }
}


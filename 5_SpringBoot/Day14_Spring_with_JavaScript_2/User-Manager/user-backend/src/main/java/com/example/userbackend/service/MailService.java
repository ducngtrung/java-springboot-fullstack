package com.example.userbackend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

//After installing and starting Docker, run this command in Terminal:
//docker run -d -p 1080:1080 -p 1025:1025 maildev/maildev

@Service
@RequiredArgsConstructor
public class MailService {
    public final JavaMailSender emailSender;

    public void sendMail(String email, String subject, String body) {
        // Create a SimpleMailMessage object
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject(subject);
        message.setText(body);

        // Send Message
        emailSender.send(message);
    }
}
package com.klu.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public String sendSimpleMailAttach(String to, String subject, String text, String path) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            
            // TRUE → enables attachment
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            // Attachment
            FileSystemResource file = new FileSystemResource(new File(path));
            helper.addAttachment(file.getFilename(), file);

            mailSender.send(message);

            return "Email Sent Successfully";
        } catch (MessagingException e) {
            return "Error: " + e.getMessage();
        }
    }
    
    public String sendSimpleMail(String to, String subject, String text) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            
            // TRUE → enables attachment
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

           

            mailSender.send(message);

            return "Email Sent Successfully";
        } catch (MessagingException e) {
            return "Error: " + e.getMessage();
        }
    }
}
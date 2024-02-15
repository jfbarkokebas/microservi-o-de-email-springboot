package com.felipe.emailservice.service;

import java.time.LocalDateTime;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.felipe.emailservice.enums.StatusEmail;
import com.felipe.emailservice.models.EmailModel;
import com.felipe.emailservice.repositories.EmailRepository;

@Service
public class EmailService {

    EmailRepository emailRepository;
    private JavaMailSender emailSender;

    public EmailService(EmailRepository emailRepository, JavaMailSender emailSender) {
        this.emailRepository = emailRepository;
        this.emailSender = emailSender;
    }

    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);

        } catch (MailException e) {

            emailModel.setStatusEmail(StatusEmail.ERROR);
            System.out.println(e.getMessage());

        }

        return emailRepository.save(emailModel);
    }

}

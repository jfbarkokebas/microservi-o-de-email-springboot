package com.felipe.emailservice.service;

import org.springframework.stereotype.Service;

import com.felipe.emailservice.models.EmailModel;
import com.felipe.emailservice.repositories.EmailRepository;

@Service
public class EmailService {
    
    EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public void sendEmail(EmailModel emailModel) {
        
        
    }

    
}

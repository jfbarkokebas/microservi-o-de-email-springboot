package com.felipe.emailservice.service;

import org.springframework.stereotype.Service;

import com.felipe.emailservice.repositories.EmailRepository;

@Service
public class EmailService {
    
    private EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    
}

package com.felipe.emailservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipe.emailservice.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long>{
    
}

package br.com.springcliente.services;

import br.com.springcliente.model.EmailEntity;

import java.util.Optional;

public interface EmailService {
    Iterable<EmailEntity> findAll();
    EmailEntity save(EmailEntity email);
    Optional<EmailEntity> findByEmail(String email);
}

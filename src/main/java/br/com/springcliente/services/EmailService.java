package br.com.springcliente.services;

import br.com.springcliente.model.EmailEntity;

public interface EmailService {
    Iterable<EmailEntity> findAll();
    EmailEntity save(EmailEntity email);

}

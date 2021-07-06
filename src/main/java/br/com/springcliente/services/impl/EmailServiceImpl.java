package br.com.springcliente.services.impl;

import br.com.springcliente.model.EmailEntity;
import br.com.springcliente.repository.EmailRepository;
import br.com.springcliente.services.EmailService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService {
    private final EmailRepository repository;

    public EmailServiceImpl(EmailRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<EmailEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public EmailEntity save(EmailEntity email) {
        return repository.save(email);
    }

    @Override
    public Optional<EmailEntity> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}

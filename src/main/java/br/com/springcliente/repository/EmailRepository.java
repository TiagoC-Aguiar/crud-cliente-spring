package br.com.springcliente.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.com.springcliente.model.Email;

public interface EmailRepository extends JpaRepositoryImplementation<Email, Long> {

}

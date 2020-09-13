package br.com.springcliente.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.com.springcliente.model.EmailEntity;

import java.util.List;

public interface EmailRepository extends JpaRepositoryImplementation<EmailEntity, Long> {

}

package br.com.springcliente.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.com.springcliente.model.Cliente;

public interface ClienteRepository extends JpaRepositoryImplementation<Cliente, Long> {

}

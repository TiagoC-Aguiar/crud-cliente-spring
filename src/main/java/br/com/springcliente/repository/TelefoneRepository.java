package br.com.springcliente.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.com.springcliente.model.Telefone;

public interface TelefoneRepository extends JpaRepositoryImplementation<Telefone, Long>  {
	
}

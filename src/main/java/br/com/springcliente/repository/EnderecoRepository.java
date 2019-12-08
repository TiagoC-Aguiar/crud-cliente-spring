package br.com.springcliente.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.com.springcliente.model.Endereco;

public interface EnderecoRepository extends JpaRepositoryImplementation<Endereco, Long> {

}

package br.com.springcliente.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.com.springcliente.enums.RoleName;
import br.com.springcliente.model.Cliente;

public interface ClienteRepository extends JpaRepositoryImplementation<Cliente, Long> {
	Optional<Cliente> findByNome(String nome);
}

package br.com.springcliente.repository;

import br.com.springcliente.model.Telefone;
import br.com.springcliente.model.TipoTelefone;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.Optional;

public interface TelefoneRepository extends JpaRepositoryImplementation<Telefone, Long> {

}

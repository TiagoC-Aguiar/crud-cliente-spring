package br.com.springcliente.repository;

import br.com.springcliente.enums.TipoTelefone;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.Optional;

public interface TipoTelefoneRepository extends JpaRepositoryImplementation<br.com.springcliente.model.TipoTelefone, Long> {
    Optional<br.com.springcliente.model.TipoTelefone> findByDescricao(TipoTelefone descricao);
}

package br.com.springcliente.repository;

import br.com.springcliente.enums.TipoTelefoneDesc;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.Optional;

public interface TipoTelefoneRepository extends JpaRepositoryImplementation<br.com.springcliente.model.TipoTelefone, Long> {
    Optional<br.com.springcliente.model.TipoTelefone> findByDescricao(TipoTelefoneDesc descricao);
}

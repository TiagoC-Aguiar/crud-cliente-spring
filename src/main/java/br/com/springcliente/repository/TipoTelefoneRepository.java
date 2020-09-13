package br.com.springcliente.repository;

import br.com.springcliente.enums.TipoTelefoneNome;
import br.com.springcliente.model.TipoTelefone;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.Optional;

public interface TipoTelefoneRepository extends JpaRepositoryImplementation<TipoTelefone, Long> {
    Optional<TipoTelefone> findByDescricao(TipoTelefoneNome descricao);
}

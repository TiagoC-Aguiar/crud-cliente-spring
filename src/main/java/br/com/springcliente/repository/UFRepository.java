package br.com.springcliente.repository;

import br.com.springcliente.model.UF;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UFRepository extends JpaRepository<UF, Long> {
    Optional<UF> findBySigla(String sigla);
}

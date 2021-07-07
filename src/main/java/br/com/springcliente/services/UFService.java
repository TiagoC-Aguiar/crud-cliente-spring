package br.com.springcliente.services;

import br.com.springcliente.model.UF;

import java.util.Optional;

public interface UFService {
    Optional<UF> findBySigla(String sigla);
    UF save(UF uf);
}

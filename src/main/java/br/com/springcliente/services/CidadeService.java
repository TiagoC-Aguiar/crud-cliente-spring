package br.com.springcliente.services;

import br.com.springcliente.model.Cidade;

import java.util.Optional;

public interface CidadeService {
    Optional<Cidade> findByNome(String nome);
    Cidade save(Cidade cidade);
}

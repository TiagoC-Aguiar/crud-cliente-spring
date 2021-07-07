package br.com.springcliente.services;

import br.com.springcliente.model.Bairro;

import java.util.Optional;

public interface BairroService {
    Optional<Bairro> findByNome(String nome);
    Bairro save(Bairro bairro);
}

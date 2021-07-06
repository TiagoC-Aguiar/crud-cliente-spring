package br.com.springcliente.services;

import br.com.springcliente.model.Telefone;

import java.util.Optional;

public interface TelefoneService {
    Telefone save(Telefone telefone);
    Optional<Telefone> findByNumero(String numero);
}

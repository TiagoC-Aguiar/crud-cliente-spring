package br.com.springcliente.services;

import br.com.springcliente.model.Cliente;

import java.util.Optional;

import org.springframework.stereotype.Service;

public interface ClienteService {
    Iterable<Cliente> findAll();
    Cliente findById(Long id);
    Optional<Cliente> findByNome(String nome);
    Cliente save(Cliente cliente);;
    void deleteById(Long id);
}

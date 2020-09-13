package br.com.springcliente.services;

import br.com.springcliente.model.Cliente;
import org.springframework.stereotype.Service;

public interface ClienteService {
    Iterable<Cliente> findAll();
    Cliente findById(Long id);
    Cliente save(Cliente cliente);;
    void deleteById(Long id);
}

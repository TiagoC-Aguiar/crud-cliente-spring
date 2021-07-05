package br.com.springcliente.services.impl;

import br.com.springcliente.model.Cliente;
import br.com.springcliente.repository.ClienteRepository;
import br.com.springcliente.services.ClienteService;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository repository;

    public ClienteServiceImpl(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Cliente> findAll() {
        return repository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        try {
            return repository.findById(id).orElseThrow(() -> new Exception());
        } catch (Exception e) {
            System.out.println("Erro ao buscar cliente com o ID: " + id);
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public Optional<Cliente> findByNome(String nome) {    
    	return repository.findByNome(nome);
    }    

    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}

package br.com.springcliente.services.impl;

import br.com.springcliente.model.Bairro;
import br.com.springcliente.repository.BairroRepository;
import br.com.springcliente.services.BairroService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BairroServiceImpl implements BairroService {

    private final BairroRepository repository;

    public BairroServiceImpl(BairroRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Bairro> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    @Override
    public Bairro save(Bairro bairro) {
        return repository.save(bairro);
    }
}

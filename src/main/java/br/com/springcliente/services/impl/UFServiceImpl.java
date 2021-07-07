package br.com.springcliente.services.impl;

import br.com.springcliente.model.UF;
import br.com.springcliente.repository.UFRepository;
import br.com.springcliente.services.UFService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UFServiceImpl implements UFService {
    private final UFRepository repository;

    public UFServiceImpl(UFRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<UF> findBySigla(String sigla) {
        return repository.findBySigla(sigla);
    }

    @Override
    public UF save(UF uf) {
        return repository.save(uf);
    }
}

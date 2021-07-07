package br.com.springcliente.services.impl;

import br.com.springcliente.model.Cidade;
import br.com.springcliente.repository.CidadeRepository;
import br.com.springcliente.services.CidadeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CidadeServiceImpl implements CidadeService {
    private final CidadeRepository repository;

    public CidadeServiceImpl(CidadeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Cidade> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    @Override
    public Cidade save(Cidade cidade) {
        return repository.save(cidade);
    }
}

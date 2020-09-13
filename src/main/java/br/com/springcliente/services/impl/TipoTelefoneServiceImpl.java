package br.com.springcliente.services.impl;

import br.com.springcliente.enums.TipoTelefoneNome;
import br.com.springcliente.model.TipoTelefone;
import br.com.springcliente.repository.TipoTelefoneRepository;
import br.com.springcliente.services.TipoTelefoneService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoTelefoneServiceImpl implements TipoTelefoneService {
    private final TipoTelefoneRepository repository;

    public TipoTelefoneServiceImpl(TipoTelefoneRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<TipoTelefone> findByDescricao(TipoTelefoneNome descricao) {
        return repository.findByDescricao(descricao);
    }

    @Override
    public TipoTelefone save(TipoTelefone tipoTelefone) {
        return repository.save(tipoTelefone);
    }
}

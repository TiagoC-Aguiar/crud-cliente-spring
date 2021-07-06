package br.com.springcliente.services.impl;

import br.com.springcliente.enums.TipoTelefone;
import br.com.springcliente.enums.TipoTelefoneDesc;
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
    public Optional<br.com.springcliente.model.TipoTelefone> findByDescricao(TipoTelefoneDesc descricao) {
        return repository.findByDescricao(descricao);
    }

    @Override
    public br.com.springcliente.model.TipoTelefone save(br.com.springcliente.model.TipoTelefone tipoTelefone) {
        return repository.save(tipoTelefone);
    }
}

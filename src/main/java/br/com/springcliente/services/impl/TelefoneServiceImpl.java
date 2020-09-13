package br.com.springcliente.services.impl;

import br.com.springcliente.model.Telefone;
import br.com.springcliente.model.TipoTelefone;
import br.com.springcliente.repository.TelefoneRepository;
import br.com.springcliente.services.TelefoneService;
import br.com.springcliente.services.TipoTelefoneService;
import org.springframework.stereotype.Service;

@Service
public class TelefoneServiceImpl implements TelefoneService {
    private final TelefoneRepository repository;
    private final TipoTelefoneService tipoTelefoneService;

    public TelefoneServiceImpl(TelefoneRepository repository, TipoTelefoneService tipoTelefoneService) {
        this.repository = repository;
        this.tipoTelefoneService = tipoTelefoneService;
    }

    @Override
    public Telefone save(Telefone telefone) {
        System.out.println("Telefone save() - Tipo de telefone: " + telefone.getTipoTelefone().getDescricao());
        TipoTelefone tipo = tipoTelefoneService.findByDescricao(telefone.getTipoTelefone().getDescricao()).get();
        telefone.setTipoTelefone(tipo);
        return repository.save(telefone);
    }
}

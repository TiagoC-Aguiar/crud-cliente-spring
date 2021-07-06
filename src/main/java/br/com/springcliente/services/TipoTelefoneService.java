package br.com.springcliente.services;

import br.com.springcliente.enums.TipoTelefone;
import br.com.springcliente.enums.TipoTelefoneDesc;

import java.util.Optional;

public interface TipoTelefoneService {
    Optional<br.com.springcliente.model.TipoTelefone> findByDescricao(TipoTelefoneDesc descricao);
    br.com.springcliente.model.TipoTelefone save(br.com.springcliente.model.TipoTelefone tipoTelefone);
}

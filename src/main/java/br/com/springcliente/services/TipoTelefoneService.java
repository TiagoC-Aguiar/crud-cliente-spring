package br.com.springcliente.services;

import br.com.springcliente.enums.TipoTelefoneNome;
import br.com.springcliente.model.TipoTelefone;

import java.util.Optional;

public interface TipoTelefoneService {
    Optional<TipoTelefone> findByDescricao(TipoTelefoneNome descricao);
    TipoTelefone save(TipoTelefone tipoTelefone);
}

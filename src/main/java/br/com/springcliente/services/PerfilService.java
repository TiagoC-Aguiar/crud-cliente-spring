package br.com.springcliente.services;

import br.com.springcliente.enums.RoleName;
import br.com.springcliente.model.Perfil;

import java.util.Optional;

public interface PerfilService {
    Perfil save(Perfil perfil);
    Optional<Perfil> findByNome(RoleName nome) throws Exception;
}

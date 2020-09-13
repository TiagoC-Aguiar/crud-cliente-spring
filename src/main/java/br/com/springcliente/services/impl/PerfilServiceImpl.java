package br.com.springcliente.services.impl;

import br.com.springcliente.enums.RoleName;
import br.com.springcliente.model.Perfil;
import br.com.springcliente.repository.PerfilRepository;
import br.com.springcliente.services.PerfilService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PerfilServiceImpl implements PerfilService {

    private final PerfilRepository repository;

    public PerfilServiceImpl(PerfilRepository repository) {
        this.repository = repository;
    }

    @Override
    public Perfil save(Perfil perfil) {
        return repository.save(perfil);
    }

    @Override
    public Optional<Perfil> findByNome(RoleName nome) throws Exception {
        return repository.findByNome(nome);
    }
}

package br.com.springcliente.repository;

import br.com.springcliente.enums.RoleName;
import br.com.springcliente.model.Perfil;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PerfilRepository extends CrudRepository<Perfil, Long> {
    Optional<Perfil> findByNome(RoleName nome);
}

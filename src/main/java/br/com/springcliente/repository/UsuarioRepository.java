package br.com.springcliente.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import br.com.springcliente.model.Usuario;

public interface UsuarioRepository extends JpaRepositoryImplementation<Usuario, Long> {

	Usuario findByLoginAndSenha(String login, String senha);
}

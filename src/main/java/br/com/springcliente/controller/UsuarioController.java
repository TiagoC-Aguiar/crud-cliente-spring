package br.com.springcliente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springcliente.model.Usuario;
import br.com.springcliente.repository.UsuarioRepository;

@RestController
@RequestMapping("api")
public class UsuarioController {

	private UsuarioRepository usuarioDAO;
	
	@Autowired
	public UsuarioController(UsuarioRepository usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	@PostMapping(path = "/login")
	public ResponseEntity<?> logar(@RequestBody Usuario usuario) {
		Usuario autenticado = usuarioDAO.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());
		if(autenticado == null) {
			return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(autenticado ,HttpStatus.OK);		
	}
	
	

}

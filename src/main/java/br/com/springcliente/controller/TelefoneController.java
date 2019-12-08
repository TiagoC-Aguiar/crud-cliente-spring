package br.com.springcliente.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springcliente.model.Telefone;
import br.com.springcliente.repository.TelefoneRepository;

@RestController
@RequestMapping("telefones")
public class TelefoneController {

	private TelefoneRepository telefoneDAO;
	
	@Autowired
	public TelefoneController(TelefoneRepository telefoneDAO) {
		this.telefoneDAO = telefoneDAO;
	}
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return new ResponseEntity<>(telefoneDAO.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> listarUm(@PathVariable Long id) {
		return new ResponseEntity<>(telefoneDAO.findById(id).get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@Valid @RequestBody Telefone telefone) {
		return new ResponseEntity<>(telefoneDAO.save(telefone), HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> alterar(@RequestBody Telefone telefone) {
		return new ResponseEntity<>(telefoneDAO.save(telefone), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		telefoneDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

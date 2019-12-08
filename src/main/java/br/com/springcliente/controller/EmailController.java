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

import br.com.springcliente.model.Email;
import br.com.springcliente.repository.EmailRepository;

@RestController
@RequestMapping("emails")
public class EmailController {

	private EmailRepository emailDAO;
	
	@Autowired
	public EmailController(EmailRepository emailDAO) {
		this.emailDAO = emailDAO;
	}
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return new ResponseEntity<>(emailDAO.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> listarUm(@PathVariable Long id) {
		return new ResponseEntity<>(emailDAO.findById(id).get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@Valid @RequestBody Email email) {
		return new ResponseEntity<>(emailDAO.save(email), HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> alterar(@RequestBody Email email) {
		return new ResponseEntity<>(emailDAO.save(email), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		emailDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

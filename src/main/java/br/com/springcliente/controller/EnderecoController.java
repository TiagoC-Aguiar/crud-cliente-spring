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

import br.com.springcliente.model.Endereco;
import br.com.springcliente.repository.EnderecoRepository;

//@RestController
//@RequestMapping("enderecos")
public class EnderecoController {

//	private EnderecoRepository enderecoDAO;
//	
//	@Autowired
//	public EnderecoController(EnderecoRepository enderecoDAO) {
//		this.enderecoDAO = enderecoDAO;
//	}
//	
//	@GetMapping
//	public ResponseEntity<?> listar() {
//		return new ResponseEntity<>(enderecoDAO.findAll(), HttpStatus.OK);
//	}
//	
//	@GetMapping(path = "/{id}")
//	public ResponseEntity<?> listarUm(@PathVariable Long id) {
//		return new ResponseEntity<>(enderecoDAO.findById(id).get(), HttpStatus.OK);
//	}
//	
//	@PostMapping
//	public ResponseEntity<?> cadastrar(@Valid @RequestBody Endereco endereco) {
//		return new ResponseEntity<>(enderecoDAO.save(endereco), HttpStatus.OK);
//	}
//	
//	@PutMapping(path = "/{id}")
//	public ResponseEntity<?> alterar(@RequestBody Endereco endereco) {
//		return new ResponseEntity<>(enderecoDAO.save(endereco), HttpStatus.OK);
//	}
//	
//	@DeleteMapping(path = "/{id}")
//	public ResponseEntity<?> excluir(@PathVariable Long id) {
//		enderecoDAO.deleteById(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
}

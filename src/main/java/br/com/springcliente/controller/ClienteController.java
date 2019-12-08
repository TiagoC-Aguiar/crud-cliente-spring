package br.com.springcliente.controller;

import java.util.List;

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

import br.com.springcliente.model.Cliente;
import br.com.springcliente.repository.ClienteRepository;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	private ClienteRepository clienteDAO;
	
	@Autowired
	public ClienteController(ClienteRepository clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return new ResponseEntity<>(clienteDAO.findAll(), HttpStatus.OK);
	}
	
//	@GetMapping
//	public List<Cliente> listar() {
//		return clienteDAO.findAll();
//	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> listarUm(@PathVariable Long id) {
		return new ResponseEntity<>(clienteDAO.findById(id).get(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@Valid @RequestBody Cliente Cliente) {
		return new ResponseEntity<>(clienteDAO.save(Cliente), HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> alterar(@RequestBody Cliente Cliente) {
		return new ResponseEntity<>(clienteDAO.save(Cliente), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		clienteDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}

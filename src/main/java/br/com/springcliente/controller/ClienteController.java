package br.com.springcliente.controller;

import br.com.springcliente.model.Cliente;
import br.com.springcliente.model.EmailEntity;
import br.com.springcliente.model.Telefone;
import br.com.springcliente.model.TipoTelefone;
import br.com.springcliente.repository.ClienteRepository;
import br.com.springcliente.services.ClienteService;
import br.com.springcliente.services.EmailService;
import br.com.springcliente.services.TelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	private ClienteRepository clienteDAO;
	private final ClienteService service;
	private final EmailService emailService;
	private final TelefoneService telefoneService;

	public ClienteController(ClienteService service, EmailService emailService, TelefoneService telefoneService) {
		this.service = service;
		this.emailService = emailService;
		this.telefoneService = telefoneService;
	}

	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> listarUm(@PathVariable Long id) {
		return new ResponseEntity<>(clienteDAO.findById(id).get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody Cliente cliente) {
		Cliente savedCliente = service.save(cliente);
		for(EmailEntity email : savedCliente.getEmails()) {
			email.setCliente(cliente);
			emailService.save(email);
		}
		for(Telefone telefone : savedCliente.getTelefones()) {
			System.out.println("Cadastrar cliente - tipo telefone: " + telefone.getTipoTelefone().getDescricao());
			telefone.setCliente(cliente);
			telefoneService.save(telefone);
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCliente.getId()).toUri();
		return ResponseEntity.created(location).body(savedCliente);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<?> alterar(@RequestBody Cliente cliente) {
		cliente.setCpf(this.removeCaracterCpf(cliente));
		return new ResponseEntity<>(clienteDAO.save(cliente), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		clienteDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	private String removeCaracterCpf(Cliente c) {
		String saida = "";
		for(int i =0;i<c.getCpf().length();i++) {
			if(c.getCpf().charAt(i) >= 48 && c.getCpf().charAt(i) <= 57) {
				saida += c.getCpf().charAt(i);
			}
		}
		return saida;
	}


}

package br.com.springcliente.controller;

import br.com.springcliente.model.Cliente;
import br.com.springcliente.model.EmailEntity;
import br.com.springcliente.repository.ClienteRepository;
import br.com.springcliente.services.ClienteService;
import br.com.springcliente.services.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	private ClienteRepository clienteDAO;
	private final ClienteService service;
	private final EmailService emailService;

	public ClienteController(ClienteService service, EmailService emailService) {
		this.service = service;
		this.emailService = emailService;
	}

	//	@Autowired
//	public ClienteController(ClienteRepository clienteDAO) {
//		this.clienteDAO = clienteDAO;
//	}
	
	@GetMapping
	public ResponseEntity<?> listar() {
//		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
		return ResponseEntity.ok(service.findAll());
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
	public ResponseEntity<?> cadastrar(@Valid @RequestBody Cliente cliente) {
//		cliente.setCpf(this.removeCaracterCpf(cliente));
//		return new ResponseEntity<>(clienteDAO.save(cliente), HttpStatus.OK);
		Cliente savedCliente = service.save(cliente);
		cliente.getEmails().get(0).setCliente(cliente);
		EmailEntity email = cliente.getEmails().get(0);
		emailService.save(email);
//		for(EmailEntity email : savedCliente.getEmails()) {
//			email.setCliente(savedCliente);
//			System.out.println("email: " + email.getEmail());
//			System.out.println("Cliente: " + email.getCliente().getNome());
//			emailService.save(email);
//		}
		System.out.println(email.getEmail());
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

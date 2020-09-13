package br.com.springcliente.controller;

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

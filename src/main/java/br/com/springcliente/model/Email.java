package br.com.springcliente.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Email extends AbstractEntity {

	private String email;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@javax.validation.constraints.Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	
}

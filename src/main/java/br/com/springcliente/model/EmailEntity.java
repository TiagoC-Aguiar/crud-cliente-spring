package br.com.springcliente.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "email")
public class EmailEntity extends AbstractEntity {

	@NotNull
	@NotEmpty(message = "O campo 'email' não pode ficar em branco")
	@Column(name = "email", length = 100)
	@Size(min = 10, max = 100)
	@Email
	private String email;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	@JsonIgnore
	private Cliente cliente;

//	public EmailEntity() {
//		this.cliente = new Cliente();
//	}

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

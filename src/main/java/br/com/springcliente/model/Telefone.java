package br.com.springcliente.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

@Entity
public class Telefone extends AbstractEntity {

//	@NotNull
//	@NotEmpty(message = "O campo 'número' não pode ficar em branco")
//	@Size(min = 8, max = 11)
	@Column(name = "numero", length = 9)
	private String numero;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_telefone")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private TipoTelefone tipoTelefone;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	@JsonIgnore
	private Cliente cliente;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}

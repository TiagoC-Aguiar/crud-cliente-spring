package br.com.springcliente.model;

import br.com.springcliente.enums.TipoTelefoneNome;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Telefone extends AbstractEntity {

	@NotNull
	@NotEmpty(message = "O campo 'número' não pode ficar em branco")
	@Column(name = "numero", length = 9)
	@Size(min = 8, max = 9)
	private String numero;

	@NotNull
	@Column(name = "tipo_telefone")
	private TipoTelefone tipoTelefone;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
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

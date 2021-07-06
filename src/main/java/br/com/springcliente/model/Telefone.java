package br.com.springcliente.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class Telefone implements AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty(message = "O campo 'número' não pode ficar em branco")
	@Size(min = 8, max = 11)
	@Column(name = "numero", length = 9)
	private String numero;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_tipo_telefone")
	private TipoTelefone tipoTelefone;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

}

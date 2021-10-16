package br.com.springcliente.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

@Entity(name = "email")
@Getter
@Setter
public class EmailEntity implements AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty(message = "O campo 'email' não pode ficar em branco")
	@Size(min = 10, max = 100)
	@Email
	@Column(name = "email", length = 100)
	private String email;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
}

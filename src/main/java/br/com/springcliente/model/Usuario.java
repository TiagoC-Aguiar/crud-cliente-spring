package br.com.springcliente.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Usuario implements AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String login;
	private String senha;

	public Usuario() {}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "perfil_usuario",
				joinColumns = {@JoinColumn(name = "usuario_id", referencedColumnName = "id")},
				inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
	private List<Perfil> perfils;

}

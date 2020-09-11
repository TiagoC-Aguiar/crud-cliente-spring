package br.com.springcliente.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario extends AbstractEntity {

	private String nome;
	private String login;
	private String senha;

	public Usuario() {}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "perfil_usuario",
				joinColumns = {@JoinColumn(name = "usuario_id", referencedColumnName = "id")},
				inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
	private List<Perfil> perfils;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Perfil> getPerfils() {
		return perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}
}

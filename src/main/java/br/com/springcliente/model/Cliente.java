package br.com.springcliente.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Cliente extends AbstractEntity {

//	@NotNull
//	@NotEmpty(message = "O campo 'nome' não pode ficar em branco")
//	@Size(min = 3, max = 100)
	@Column(name = "nome", length = 100)
	private String nome;

//	@NotNull
//	@NotEmpty(message = "O campo 'cpf' não pode ficar em branco")
//	@Size(min = 11, max = 11)
	@Column(name = "cpf", length = 11)
	private String cpf;

//	@NotNull
//	@NotEmpty(message = "O campo 'cep' não pode ficar em branco")
//	@Size(min = 5, max = 8)
	@Column(name = "cep", length = 8)
	private String cep;

//	@NotNull
//	@NotEmpty(message = "O campo 'logradouro' não pode ficar em branco")
//	@Size(min = 6, max = 100)
	@Column(name = "logradouro", length = 100)
	private String logradouro;

//	@NotNull
//	@NotEmpty(message = "O campo 'bairro' não pode ficar em branco")
//	@Size(min = 4, max = 100)
	@Column(name = "bairro", length = 100)
	private String bairro;

//	@NotNull
//	@NotEmpty(message = "O campo 'cidade' não pode ficar em branco")
//	@Size(min = 6, max = 100)
	@Column(name = "cidade", length = 100)
	private String cidade;

//	@NotNull
//	@NotEmpty(message = "O campo 'UF' não pode ficar em branco")
//	@Size(min = 2, max = 2)
	@Column(name = "uf", length = 2)
	private String uf;

	@Column(name = "complemento", length = 100)
	private String complemento;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<EmailEntity> emails;

	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
	private List<Telefone> telefones;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public List<EmailEntity> getEmails() {
		return emails;
	}

	public void setEmails(List<EmailEntity> emails) {
		this.emails = emails;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	private String formataCpf() {
		String saida = "";
		for(int i =0;i<this.cpf.length();i++) {
			if(i == 3 || i == 7) {
				saida += ".";
			}
			if(i == 10) {
				saida += "-";
			}
			saida += this.cpf.charAt(i);
		}
		return saida;
	}	

}

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
public class Cliente implements AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty(message = "O campo 'nome' não pode ficar em branco")
	@Size(min = 3, max = 100)
	@Column(name = "nome", length = 100)
	private String nome;

	@NotNull
	@NotEmpty(message = "O campo 'cpf' não pode ficar em branco")
	@Size(min = 11, max = 11)
	@Column(name = "cpf", length = 11)
	private String cpf;

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

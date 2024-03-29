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
public class UF implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty(message = "O campo 'sigla' não pode ficar em branco")
    @Column(name = "sigla", length = 2)
    private String sigla;

    @NotNull
    @NotEmpty(message = "O campo 'nome' não pode ficar em branco")
    @Column(name = "nome", length = 255)
    private String nome;
}

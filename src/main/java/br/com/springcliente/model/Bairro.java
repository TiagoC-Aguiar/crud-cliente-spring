package br.com.springcliente.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Bairro implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty(message = "O campo 'nome' não pode ficar em branco")
    @Column(name = "nome", length = 255)
    private String nome;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

}

package br.com.springcliente.model;

import br.com.springcliente.enums.TipoTelefoneNome;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

@Entity(name = "tipo_telefone")
public class TipoTelefone extends AbstractEntity {

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_telefone")
    private TipoTelefoneNome descricao;

    public TipoTelefoneNome getDescricao() {
        return descricao;
    }

    public void setDescricao(TipoTelefoneNome descricao) {
        this.descricao = descricao;
    }
}

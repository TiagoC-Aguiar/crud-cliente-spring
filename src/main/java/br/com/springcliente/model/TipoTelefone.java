package br.com.springcliente.model;

import br.com.springcliente.enums.TipoTelefoneNome;

import javax.persistence.*;
//import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "tipo_telefone")
public class TipoTelefone extends AbstractEntity {

//    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_telefone")
    private TipoTelefoneNome descricao;

    @OneToMany(mappedBy = "tipoTelefone", fetch = FetchType.LAZY)
    private List<Telefone> telefones;

    public TipoTelefoneNome getDescricao() {
        return descricao;
    }

    public void setDescricao(TipoTelefoneNome descricao) {
        this.descricao = descricao;
    }
}

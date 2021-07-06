package br.com.springcliente.model;

import br.com.springcliente.enums.TipoTelefoneDesc;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "tipo_telefone")
@Getter
@Setter
public class TipoTelefone implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_telefone")
    private TipoTelefoneDesc descricao;

}

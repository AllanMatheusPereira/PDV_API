
package br.unipar.programacaointernet.pontodevenda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter

public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantidade;

    private BigDecimal valor_Unitario;

    private BigDecimal valor_Total;

    @ManyToOne
    private Venda venda;

    @ManyToOne
    private Produto produto;
}

package br.unipar.programacaointernet.pontodevenda.model;

import jakarta.persistence.*;
import jdk.jfr.ContentType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String observacoes;

    private LocalDate data;

    private BigDecimal total;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "venda", orphanRemoval = true,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ItemVenda> itens = new ArrayList<>();
}

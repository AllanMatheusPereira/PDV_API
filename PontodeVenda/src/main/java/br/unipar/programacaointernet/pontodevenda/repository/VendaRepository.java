package br.unipar.programacaointernet.pontodevenda.repository;

import br.unipar.programacaointernet.pontodevenda.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
    List<Venda> findByDataBetween(LocalDate dataInicial, LocalDate dataFinal);
}

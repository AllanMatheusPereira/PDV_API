package br.unipar.programacaointernet.pontodevenda.repository;

import br.unipar.programacaointernet.pontodevenda.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}

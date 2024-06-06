package br.unipar.programacaointernet.pontodevenda.repository;

import br.unipar.programacaointernet.pontodevenda.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}

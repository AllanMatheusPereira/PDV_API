package br.unipar.programacaointernet.pontodevenda.service;

import br.unipar.programacaointernet.pontodevenda.model.Produto;
import br.unipar.programacaointernet.pontodevenda.model.Venda;
import br.unipar.programacaointernet.pontodevenda.repository.ProdutoRepository;
import br.unipar.programacaointernet.pontodevenda.repository.VendaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    private final VendaRepository vendaRepository;
    public VendaService(VendaRepository vendaRepository){
        this.vendaRepository = vendaRepository;
    }

    public List<Venda> getAll(){
        return this.vendaRepository.findAll();
    }

    public Venda save(Venda venda){

//        fazer a logica pra inserir id da venda no item venda.....0

        return this.vendaRepository.save(venda);
    }

    public Venda getById(Integer id) {
        Optional<Venda> optionalVenda = this.vendaRepository.findById(id);
        if (optionalVenda.isPresent()) {
            return optionalVenda.get();
        } else {
            throw new RuntimeException("Venda não encontrada com o id: " + id);
        }
    }

    public Venda update(Integer id, Venda venda) {
        Optional<Venda> optionalVenda = this.vendaRepository.findById(id);
        if (optionalVenda.isPresent()) {
            Venda existingVenda = optionalVenda.get();
            existingVenda.setObservacoes(venda.getObservacoes());
            existingVenda.setData(venda.getData());
            existingVenda.setTotal(venda.getTotal());
            existingVenda.setCliente(venda.getCliente());
            return this.vendaRepository.save(existingVenda);
        } else {
            throw new RuntimeException("Venda não encontrada com o id: " + id);
        }
    }

    public String delete(Integer id) {
        if (this.vendaRepository.existsById(id)) {
            this.vendaRepository.deleteById(id);
            return "Venda deletada com sucesso!!!";
        } else {
            throw new RuntimeException("Venda não encontrada com o id: " + id);
        }
    }

    public List<Venda> getByDataBetween(LocalDate dataInicial, LocalDate dataFinal) {
        return vendaRepository.findByDataBetween(dataInicial, dataFinal);
    }
}


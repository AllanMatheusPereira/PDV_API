package br.unipar.programacaointernet.pontodevenda.service;

import br.unipar.programacaointernet.pontodevenda.model.ItemVenda;
import br.unipar.programacaointernet.pontodevenda.model.Produto;
import br.unipar.programacaointernet.pontodevenda.repository.ItemVendaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemVendaService {
    private final ItemVendaRepository itemVendaRepository;
    public ItemVendaService(ItemVendaRepository itemVendaRepository){
            this.itemVendaRepository = itemVendaRepository;
        }

    public List<ItemVenda> getAll(){
            return this.itemVendaRepository.findAll();
        }

    public ItemVenda save(ItemVenda itemVenda){
            return this.itemVendaRepository.save(itemVenda);
        }


    public ItemVenda getById(Integer id) {
        Optional<ItemVenda> optionalItemVenda = this.itemVendaRepository.findById(id);
        if (optionalItemVenda.isPresent()) {
            return optionalItemVenda.get();
        } else {
            throw new RuntimeException("Item não encontrado com o id: " + id);
        }
    }

    public ItemVenda update(Integer id, ItemVenda itemVenda) {
        Optional<ItemVenda> optionalItemVenda = this.itemVendaRepository.findById(id);
        if (optionalItemVenda.isPresent()) {
            ItemVenda existingItemVenda = optionalItemVenda.get();
            existingItemVenda.setQuantidade(itemVenda.getQuantidade());
            existingItemVenda.setValor_Unitario(itemVenda.getValor_Unitario());
            existingItemVenda.setValor_Total(itemVenda.getValor_Total());
            existingItemVenda.setVenda(itemVenda.getVenda());
            existingItemVenda.setProduto(itemVenda.getProduto());
            return this.itemVendaRepository.save(existingItemVenda);
        } else {
            throw new RuntimeException("Item não encontrado com o id: " + id);
        }
    }

    public String delete(Integer id) {
        if (this.itemVendaRepository.existsById(id)) {
            this.itemVendaRepository.deleteById(id);
            return "Item removido com sucesso!!!";
        } else {
            throw new RuntimeException("Item não encontrado com o id: " + id);
        }
    }
}


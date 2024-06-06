package br.unipar.programacaointernet.pontodevenda.service;

import br.unipar.programacaointernet.pontodevenda.model.Cliente;
import br.unipar.programacaointernet.pontodevenda.model.Produto;
import br.unipar.programacaointernet.pontodevenda.repository.ClienteRepository;
import br.unipar.programacaointernet.pontodevenda.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAll(){
        return this.produtoRepository.findAll();
    }

    public Produto save(Produto produto){
        return this.produtoRepository.save(produto);
    }

    public Produto getById(Integer id) {
        Optional<Produto> optionalProduto = this.produtoRepository.findById(id);
        if (optionalProduto.isPresent()) {
            return optionalProduto.get();
        } else {
            throw new RuntimeException("Produto não encontrado com o id: " + id);
        }
    }

    public Produto update(Integer id, Produto produto) {
        Optional<Produto> optionalProduto = this.produtoRepository.findById(id);
        if (optionalProduto.isPresent()) {
            Produto existingProduto = optionalProduto.get();
            existingProduto.setDescricao(produto.getDescricao());
            existingProduto.setValor(produto.getValor());
            existingProduto.setCategoria(produto.getCategoria());
            return this.produtoRepository.save(existingProduto);
        } else {
            throw new RuntimeException("Produto não encontrado com o id: " + id);
        }
    }

    public String delete(Integer id) {
        if (this.produtoRepository.existsById(id)) {
            this.produtoRepository.deleteById(id);
            return "Produto deletado com sucesso!!!";
        } else {
            throw new RuntimeException("Produto não encontrado com o id: " + id);
        }
    }

}

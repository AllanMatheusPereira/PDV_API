package br.unipar.programacaointernet.pontodevenda.controller;

import br.unipar.programacaointernet.pontodevenda.model.Produto;
import br.unipar.programacaointernet.pontodevenda.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Produto API", description = "API para gerenciamento de produtos")
public class ProdutoApiController {

    private final ProdutoService produtoService;

    public ProdutoApiController (ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping(path = "/api/produtos")
    @Operation(summary = "Obter todos os produtos", description = "Retorna uma lista de todos os produtos")
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(
                this.produtoService.getAll()
        );
    }

    @PostMapping(path = "/api/produtos")
    @Operation(summary = "Salvar produto", description = "Salva um novo produto e retorna o produto salvo", parameters = {
            @Parameter(name = "produto", description = "Produto que será adicionado. " + "Não é necessário incluir o ID.")})
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        return ResponseEntity.ok(
                this.produtoService.save(produto)
        );
    }

    @GetMapping(path = "/api/produtos/{id}")
    @Operation(summary = "Obter produto por ID", description = "Retorna um produto pelo ID")
    public ResponseEntity<Produto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.produtoService.getById(id));
    }

    @PutMapping(path = "/api/produtos/{id}")
    @Operation(summary = "Atualizar produto", description = "Atualiza um produto existente pelo ID", parameters = {
            @Parameter(name = "id", description = "ID do produto que será atualizado"),
            @Parameter(name = "produto", description = "Produto com os novos dados. Não é necessário incluir o ID.")})
    public ResponseEntity<Produto> update(@PathVariable Integer id, @RequestBody Produto produto) {
        return ResponseEntity.ok(this.produtoService.update(id, produto));
    }

    @DeleteMapping(path = "/api/produtos/{id}")
    @Operation(summary = "Excluir produto", description = "Exclui um produto existente pelo ID", parameters = {
            @Parameter(name = "id", description = "ID do produto que será excluído")})
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        String message = this.produtoService.delete(id);
        return ResponseEntity.ok(message);
    }
}



package br.unipar.programacaointernet.pontodevenda.controller;

import br.unipar.programacaointernet.pontodevenda.model.ItemVenda;
import br.unipar.programacaointernet.pontodevenda.model.Produto;
import br.unipar.programacaointernet.pontodevenda.service.ItemVendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Itens venda API", description = "API para gerenciamento de itens da venda")
public class ItemVendaApiController {

    private final ItemVendaService itemVendaService;

    public ItemVendaApiController(ItemVendaService itemVendaService) {
        this.itemVendaService = itemVendaService;
    }

    @GetMapping(path = "/api/itensvendas")
    @Operation(summary = "Obter todos os itens das vendas", description = "Retorna uma lista de todos os itens das vendas")
    public ResponseEntity<List<ItemVenda>> getAll() {
        return ResponseEntity.ok(
                this.itemVendaService.getAll()
        );
    }

    @PostMapping(path = "/api/itensvendas")
    @Operation(summary = "Salvar itens das venda", description = "Salva novos itens das vendas e retorna o item salvo", parameters = {
            @Parameter(name = "item venda", description = "Itens da venda que seram adicionados. " + "Não é necessário incluir o ID.")})
    public ResponseEntity<ItemVenda> save(@RequestBody ItemVenda itemVenda) {
        return ResponseEntity.ok(
                this.itemVendaService.save(itemVenda)
        );
    }

    @GetMapping(path = "/api/itensvendas/{id}")
    @Operation(summary = "Obter itens das vendas por ID", description = "Retorna item da venda pelo ID")
    public ResponseEntity<ItemVenda> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.itemVendaService.getById(id));
    }

    @PutMapping(path = "/api/itensvendas")
    @Operation(summary = "Atualizar item de venda", description = "Atualiza um item de venda existente pelo ID", parameters = {
            @Parameter(name = "id", description = "ID do item de venda que será atualizado"),
            @Parameter(name = "itemVenda", description = "Item de venda com os novos dados. Não é necessário incluir o ID.")})
    public ResponseEntity<ItemVenda> update(@PathVariable Integer id, @RequestBody ItemVenda itemVenda) {
        return ResponseEntity.ok(this.itemVendaService.update(id, itemVenda));
    }

    @DeleteMapping(path = "/api/itensvendas")
    @Operation(summary = "Excluir item de venda", description = "Exclui um item de venda existente pelo ID", parameters = {
            @Parameter(name = "id", description = "ID do item de venda que será excluído")})
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        String message = this.itemVendaService.delete(id);
        return ResponseEntity.ok(message);
    }
}

package br.unipar.programacaointernet.pontodevenda.controller;

import br.unipar.programacaointernet.pontodevenda.model.Venda;
import br.unipar.programacaointernet.pontodevenda.service.VendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Tag(name = "Venda API", description = "API para gerenciamento de vendas")
public class VendaApiController {

    private final VendaService vendaService;

    public VendaApiController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @GetMapping(path = "/api/vendas")
    @Operation(summary = "Obter todos as vendas", description = "Retorna uma lista de todas as vendas")
    public ResponseEntity<List<Venda>> getAll() {
        return ResponseEntity.ok(this.vendaService.getAll());
    }

    @PostMapping(path = "/api/vendas")
    @Operation(summary = "Salvar venda", description = "Salva um novo usuário e retorna o usuário salvo", parameters = {
            @Parameter(name = "venda", description = "Venda que será adicionada. " + "Não é necessário incluir o ID.")})
    public ResponseEntity<Venda> save(@RequestBody Venda venda) {
        return ResponseEntity.ok(this.vendaService.save(venda));
    }

    @GetMapping(path = "/api/venda/{id}")
    @Operation(summary = "Obter vendas por ID", description = "Retorna uma venda pelo ID")
    public ResponseEntity<Venda> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.vendaService.getById(id));
    }

    @PutMapping(path = "/api/vendas/{id}")
    @Operation(summary = "Atualizar venda", description = "Atualiza uma venda existente pelo ID", parameters = {
            @Parameter(name = "id", description = "ID da venda que será atualizada"),
            @Parameter(name = "venda", description = "Venda com os novos dados. Não é necessário incluir o ID.")})
    public ResponseEntity<Venda> update(@PathVariable Integer id, @RequestBody Venda venda) {
        return ResponseEntity.ok(this.vendaService.update(id, venda));
    }

    @DeleteMapping(path = "/api/vendas/{id}")
    @Operation(summary = "Excluir venda", description = "Exclui uma venda existente pelo ID", parameters = {
            @Parameter(name = "id", description = "ID da venda que será excluída")})
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        String message = this.vendaService.delete(id);
        return ResponseEntity.ok(message);
    }

    @GetMapping(path = "/api/vendas/filtrar")
    @Operation(summary = "Filtrar vendas por data", description = "Retorna uma lista de vendas filtradas por intervalo de datas")
    public ResponseEntity<List<Venda>> getByDataBetween(
            @RequestParam("dataInicial") LocalDate dataInicial,
            @RequestParam("dataFinal") LocalDate dataFinal) {
        return ResponseEntity.ok(this.vendaService.getByDataBetween(dataInicial, dataFinal));
    }
}


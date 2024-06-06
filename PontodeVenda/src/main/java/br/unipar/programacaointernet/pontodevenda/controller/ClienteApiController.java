package br.unipar.programacaointernet.pontodevenda.controller;

import br.unipar.programacaointernet.pontodevenda.model.Cliente;
import br.unipar.programacaointernet.pontodevenda.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Cliente API", description = "API para gerenciamento de clientes")
public class ClienteApiController {

    private final ClienteService clienteService;

    public ClienteApiController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(path = "/api/clientes")
    @Operation(summary = "Obter todos os clientes", description = "Retorna uma lista de todos os clientes")
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(
                this.clienteService.getAll()
        );
    }
    @PostMapping(path = "/api/clientes")
    @Operation(summary = "Salvar cliente", description = "Salva um novo cliente e retorna o cliente salvo", parameters = {
            @Parameter(name = "cliente", description = "Cliente que será adicionado. " + "Não é necessário incluir o ID.")})
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(
                this.clienteService.save(cliente)
        );
    }

    @GetMapping(path = "/api/clientes/{id}")
    @Operation(summary = "Obter cliente por ID", description = "Retorna um cliente pelo ID")
    public ResponseEntity<Cliente> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(this.clienteService.getById(id));
    }

    @PutMapping("/api/clientes/{id}")
    @Operation(summary = "Atualizar cliente", description = "Atualiza um cliente existente pelo ID", parameters = {
            @Parameter(name = "id", description = "ID do cliente que será atualizado"),
            @Parameter(name = "cliente", description = "Cliente com os novos dados. Não é necessário incluir o ID.")})
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
        return ResponseEntity.ok(this.clienteService.update(id, cliente));
    }

    @DeleteMapping("/api/clientes/{id}")
    @Operation(summary = "Excluir cliente", description = "Exclui um cliente existente pelo ID", parameters = {
            @Parameter(name = "id", description = "ID do cliente que será excluído")})
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        String message = this.clienteService.delete(id);
        return ResponseEntity.ok(message);
    }
}



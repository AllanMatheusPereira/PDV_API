package br.unipar.programacaointernet.pontodevenda.service;

import br.unipar.programacaointernet.pontodevenda.model.Cliente;
import br.unipar.programacaointernet.pontodevenda.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getAll(){
        return this.clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    public Cliente getById(Integer id) {
        Optional<Cliente> optionalCliente = this.clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            return optionalCliente.get();
        } else {
            throw new RuntimeException("Cliente não encontrado com o id: " + id);
        }
    }

    public Cliente update(Integer id, Cliente cliente) {
        Optional<Cliente> optionalCliente = this.clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            Cliente existingCliente = optionalCliente.get();
            existingCliente.setNome(cliente.getNome());
            existingCliente.setTelefone(cliente.getTelefone());
            existingCliente.setEmail(cliente.getEmail());
            return this.clienteRepository.save(existingCliente);
        } else {
            throw new RuntimeException("Cliente não encontrado com o id: " + id);
        }
    }

    public String delete(Integer id) {
        if (this.clienteRepository.existsById(id)) {
            this.clienteRepository.deleteById(id);
            return "Cliente deletado com sucesso!!!";
        } else {
            throw new RuntimeException("Cliente não encontrado com o id: " + id);
        }
    }
}
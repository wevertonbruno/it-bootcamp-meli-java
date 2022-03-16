package repositories.impl;

import entities.Cliente;
import exceptions.EntityNotFoundException;
import repositories.ClienteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class InMemoryClienteRepositoryImpl implements ClienteRepository {

    private List<Cliente> repository = new ArrayList<>();

    @Override
    public void create(Cliente cliente) {
        repository.add(cliente);
    }

    @Override
    public void update(UUID ID, Cliente cliente) {
        Cliente clienteOld = get(ID);
        clienteOld.setNome(cliente.getNome());
        clienteOld.setSobrenome(cliente.getSobrenome());
    }

    @Override
    public void delete(UUID ID) {
        this.repository = this.repository.stream()
                .filter(entity -> !entity.getID().equals(ID))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cliente> listAll() {
        return this.repository.stream().collect(Collectors.toList());
    }

    @Override
    public Cliente get(UUID id) throws EntityNotFoundException{
        for(Cliente cliente : repository){
            if(cliente.getID().equals(id)){
                return cliente;
            }
        }

        throw new EntityNotFoundException("Cliente nao encontrado.");
    }
}

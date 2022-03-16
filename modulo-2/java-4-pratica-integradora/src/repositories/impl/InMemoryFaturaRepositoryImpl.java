package repositories.impl;

import entities.Fatura;
import exceptions.EntityNotFoundException;
import repositories.FaturaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class InMemoryFaturaRepositoryImpl implements FaturaRepository {
    private List<Fatura> repository = new ArrayList<>();

    @Override
    public void create(Fatura fatura) {
        repository.add(fatura);
    }

    @Override
    public void update(UUID ID, Fatura fatura) {
        Fatura faturaOld = get(ID);
        faturaOld.setCliente(fatura.getCliente());
        faturaOld.setProdutos(fatura.getProdutos());
    }

    @Override
    public void delete(UUID ID) {
        this.repository = this.repository.stream()
                .filter(entity -> !entity.getID().equals(ID))
                .collect(Collectors.toList());
    }

    @Override
    public List<Fatura> listAll() {
        return this.repository.stream().collect(Collectors.toList());
    }

    @Override
    public Fatura get(UUID id) throws EntityNotFoundException{
        for(Fatura fatura : repository){
            if(fatura.getID().equals(id)){
                return fatura;
            }
        }

        throw new EntityNotFoundException("Fatura nao encontrada.");
    }
}
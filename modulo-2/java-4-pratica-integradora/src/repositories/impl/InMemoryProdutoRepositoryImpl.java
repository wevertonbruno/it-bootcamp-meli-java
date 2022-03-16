package repositories.impl;

import entities.Produto;
import entities.Produto;
import exceptions.EntityNotFoundException;
import repositories.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class InMemoryProdutoRepositoryImpl implements ProdutoRepository {
    private List<Produto> repository = new ArrayList<>();

    @Override
    public void create(Produto produto) {
        repository.add(produto);
    }

    @Override
    public void update(UUID ID, Produto produto) {
        Produto produtoOld = get(ID);
        produtoOld.setNome(produto.getNome());
        produtoOld.setPrecoUnitario(produto.getPrecoUnitario());
    }

    @Override
    public void delete(UUID ID) {
        this.repository = this.repository.stream()
                .filter(entity -> !entity.getID().equals(ID))
                .collect(Collectors.toList());
    }

    @Override
    public List<Produto> listAll() {
        return this.repository.stream().collect(Collectors.toList());
    }

    @Override
    public Produto get(UUID id) throws EntityNotFoundException {
        for(Produto produto : repository){
            if(produto.getID().equals(id)){
                return produto;
            }
        }
        throw new EntityNotFoundException("Produto nao encontrado.");
    }
}

package services;

import entities.Cliente;
import entities.Fatura;
import entities.ItemProduto;
import entities.Produto;
import exceptions.EntityNotFoundException;
import repositories.ClienteRepository;
import repositories.FaturaRepository;
import repositories.ProdutoRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class SupermercadoService {
    private ClienteRepository clienteRepository;
    private ProdutoRepository produtoRepository;
    private FaturaRepository faturaRepository;

    public SupermercadoService(ClienteRepository clienteRepository, ProdutoRepository produtoRepository, FaturaRepository faturaRepository) {
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.faturaRepository = faturaRepository;
    }

    public void addCliente(String nome, String sobrenome){
        Cliente cliente = new Cliente(nome, sobrenome);
        this.clienteRepository.create(cliente);
    }

    public void removerCliente(String ID){
        this.clienteRepository.delete(UUID.fromString(ID));
    }

    public Cliente getCliente(String ID){
        return this.clienteRepository.get(UUID.fromString(ID));
    }


    public void addProduto(String nome, Double preco){
        Produto produto = new Produto(nome, BigDecimal.valueOf(preco));
        this.produtoRepository.create(produto);
    }

    public void addFatura(Cliente cliente, List<ItemProduto> produtos){
        Fatura fatura = new Fatura(cliente, produtos);
        this.faturaRepository.create(fatura);
    }

    public List<Cliente> listAllClientes(){
        return this.clienteRepository.listAll();
    }
}

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

    public Produto addProduto(String nome, Double preco){
        Produto produto = new Produto(nome, BigDecimal.valueOf(preco));
        this.produtoRepository.create(produto);
        return produto;
    }

    public Fatura addFatura(String clienteId, List<ItemProduto> produtos){
        Cliente cliente = getCliente(clienteId);
        Fatura fatura = new Fatura(cliente, produtos);

        this.faturaRepository.create(fatura);

        return fatura;
    }

    public Fatura getFatura(String ID){
        return this.faturaRepository.get(UUID.fromString(ID));
    }

    public void printFatura(String faturaId){
        Fatura fatura = getFatura(faturaId);
        System.out.println(fatura.toPrint());
    }

    public List<Cliente> listAllClientes(){
        return this.clienteRepository.listAll();
    }
}

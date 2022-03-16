import entities.Cliente;
import entities.Fatura;
import entities.ItemProduto;
import entities.Produto;
import exceptions.EntityNotFoundException;
import repositories.ClienteRepository;
import repositories.FaturaRepository;
import repositories.ProdutoRepository;
import repositories.impl.InMemoryClienteRepositoryImpl;
import repositories.impl.InMemoryFaturaRepositoryImpl;
import repositories.impl.InMemoryProdutoRepositoryImpl;
import services.SupermercadoService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner CONSOLE = new Scanner(System.in);

        ClienteRepository clienteRepository = new InMemoryClienteRepositoryImpl();
        ProdutoRepository produtoRepository = new InMemoryProdutoRepositoryImpl();
        FaturaRepository faturaRepository = new InMemoryFaturaRepositoryImpl();

        SupermercadoService supermercadoService = new SupermercadoService(clienteRepository, produtoRepository, faturaRepository);

        supermercadoService.addCliente("Weverton", "Santos");
        supermercadoService.addCliente("Valeria", "Coelho");
        supermercadoService.addCliente("Jose", "Silva");

        Produto produto1 = supermercadoService.addProduto("Arroz", 5.65);
        Produto produto2 = supermercadoService.addProduto("Feijao", 7.25);
        Produto produto3 = supermercadoService.addProduto("Cerveja", 3.35);
        Produto produto4 = supermercadoService.addProduto("Carne de Sol", 42.40);

        System.out.println("\n----------- CLIENTES ------------\n");
        supermercadoService.listAllClientes().forEach(System.out::println);

        System.out.println("\n----------- SOLICITAR DADOS DE CLIENTE ------------\n");
        System.out.print("Codigo de identificacao: ");

        try{
            String clienteId = CONSOLE.next();

            Cliente cliente = supermercadoService.getCliente(clienteId);
            System.out.println(cliente);

            System.out.println("\n----------- CRIAR FATURA ------------\n");
            ItemProduto item1 = new ItemProduto(produto1, 5);
            ItemProduto item2 = new ItemProduto(produto2, 3);
            ItemProduto item3 = new ItemProduto(produto3, 15);

            Fatura fatura = supermercadoService.addFatura(clienteId, Arrays.asList(item1, item2, item3));
            supermercadoService.printFatura(fatura.getID().toString());

        }catch (EntityNotFoundException e) {
            System.out.println("Cliente nao encontrado.");
        }



    }
}

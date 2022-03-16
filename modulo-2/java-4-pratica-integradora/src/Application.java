import entities.Cliente;
import exceptions.EntityNotFoundException;
import repositories.ClienteRepository;
import repositories.FaturaRepository;
import repositories.ProdutoRepository;
import repositories.impl.InMemoryClienteRepositoryImpl;
import repositories.impl.InMemoryFaturaRepositoryImpl;
import repositories.impl.InMemoryProdutoRepositoryImpl;
import services.SupermercadoService;

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

        System.out.println("\n----------- CLIENTES ------------\n");
        supermercadoService.listAllClientes().forEach(System.out::println);

        System.out.println("\n----------- SOLICITAR DADOS DE CLIENTE ------------\n");
        System.out.print("Codigo de identificacao: ");

        try{
            Cliente cliente = supermercadoService.getCliente(CONSOLE.next());
            System.out.println(cliente);
        }catch (EntityNotFoundException e) {
            System.out.println("Cliente nao encontrado.");
        }

    }
}

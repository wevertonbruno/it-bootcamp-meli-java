package exercicio1;

import exercicio1.entities.ClienteBasico;
import exercicio1.entities.ClienteCobrador;
import exercicio1.entities.ClienteExecutivo;

public class Application {
    public static void main(String[] args) {
        ClienteBasico clienteBasico = new ClienteBasico();
        ClienteCobrador clienteCobrador = new ClienteCobrador();
        ClienteExecutivo clienteExecutivo = new ClienteExecutivo();

        clienteBasico.consultar();
        clienteBasico.sacar();
        clienteCobrador.consultar();
        clienteCobrador.sacar();
        clienteExecutivo.depositar();
        clienteExecutivo.transferir();
    }
}

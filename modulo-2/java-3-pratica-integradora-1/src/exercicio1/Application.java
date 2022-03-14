package exercicio1;

import exercicio1.entities.ClienteBasico;
import exercicio1.entities.ClienteCobrador;
import exercicio1.entities.ClienteExecutivo;

public class Application {
    public static void main(String[] args) {
        ClienteBasico clienteBasico = new ClienteBasico();
        ClienteCobrador clienteCobrador = new ClienteCobrador();
        ClienteExecutivo clienteExecutivo = new ClienteExecutivo();

        clienteBasico.consulta();
        clienteBasico.saque();
        clienteCobrador.consulta();
        clienteCobrador.saque();
        clienteExecutivo.deposito();
        clienteExecutivo.transferencia();
    }
}

package exercicio1.entities;

public class ClienteExecutivo implements Deposito, Transferencia{

    @Override
    public void transacaoOK() {
        System.out.println("Transacao OK");
    }

    @Override
    public void transacaoNaoOk() {
        System.out.println("Transacao Falhou");
    }

    @Override
    public void depositar() {
        System.out.println("Executando...");
    }

    @Override
    public void transferir() {
        System.out.println("Executando...");
    }
}

package exercicio1.entities;

public class Deposito implements Transacao{
    @Override
    public void transacaoOK() {
        System.out.println("Deposito Realizado");
    }

    @Override
    public void transacaoNaoOk() {
        System.out.println("Falha ao realizar deposito");
    }
}

package exercicio1.entities;

public class Transferencia implements Transacao{
    @Override
    public void transacaoOK() {
        System.out.println("Transferencia Realizado");
    }

    @Override
    public void transacaoNaoOk() {
        System.out.println("Falha ao realizar transferencia");
    }
}

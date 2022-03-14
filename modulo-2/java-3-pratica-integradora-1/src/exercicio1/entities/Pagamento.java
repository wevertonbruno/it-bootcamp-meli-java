package exercicio1.entities;

public class Pagamento implements Transacao{
    @Override
    public void transacaoOK() {
        System.out.println("Pagamento Realizado");
    }

    @Override
    public void transacaoNaoOk() {
        System.out.println("Falha ao realizar Pagamento");
    }
}

package exercicio1.entities;

public class Saque implements Transacao{
    @Override
    public void transacaoOK() {
        System.out.println("Saque Realizado");
    }

    @Override
    public void transacaoNaoOk() {
        System.out.println("Falha ao realizar saque");
    }
}

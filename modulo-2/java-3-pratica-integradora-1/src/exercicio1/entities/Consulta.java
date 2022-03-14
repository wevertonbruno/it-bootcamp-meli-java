package exercicio1.entities;

public class Consulta implements Transacao{
    @Override
    public void transacaoOK() {
        System.out.println("Consulta Realizada");
    }

    @Override
    public void transacaoNaoOk() {
        System.out.println("Falha ao realizar consulta");
    }
}

package exercicio1.entities;

public class ClienteCobrador implements Consulta, Saque{
    @Override
    public void consultar() {
        System.out.println("Executando...");
    }

    @Override
    public void sacar() {
        System.out.println("Executando...");
    }

    @Override
    public void transacaoOK() {
        System.out.println("Transacao OK");
    }

    @Override
    public void transacaoNaoOk() {
        System.out.println("Transacao Falhou");
    }
}

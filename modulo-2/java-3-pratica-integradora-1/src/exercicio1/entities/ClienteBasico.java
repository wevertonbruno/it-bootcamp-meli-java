package exercicio1.entities;

public class ClienteBasico implements Consulta, Pagamento, Saque{
    @Override
    public void consultar() {
        System.out.println("Executando...");
    }

    @Override
    public void pagar() {
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

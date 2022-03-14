package exercicio1.entities;

public class ClienteBasico {
    public void consulta(){
        Transacao transacao = new Consulta();
        transacao.transacaoOK();
    }

    public void pagamento(){
        Transacao transacao = new Pagamento();
        transacao.transacaoOK();
    }

    public void saque(){
        Transacao transacao = new Saque();
        transacao.transacaoOK();
    }
}

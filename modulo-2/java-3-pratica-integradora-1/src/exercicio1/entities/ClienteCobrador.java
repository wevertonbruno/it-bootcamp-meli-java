package exercicio1.entities;

public class ClienteCobrador {
    public void consulta(){
        Transacao transacao = new Consulta();
        transacao.transacaoOK();
    }

    public void saque(){
        Transacao transacao = new Saque();
        transacao.transacaoOK();
    }
}

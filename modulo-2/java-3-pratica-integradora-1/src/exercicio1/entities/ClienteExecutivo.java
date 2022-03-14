package exercicio1.entities;

public class ClienteExecutivo {
    public void deposito(){
        Transacao transacao = new Deposito();
        transacao.transacaoOK();
    }

    public void transferencia(){
        Transacao transacao = new Transferencia();
        transacao.transacaoOK();
    }
}

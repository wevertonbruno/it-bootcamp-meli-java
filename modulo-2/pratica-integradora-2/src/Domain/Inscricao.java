package Domain;

import Domain.CircuitoPago;

public class Inscricao {
    private Pessoa pessoa;
    private Double valor;

    public Inscricao(Pessoa pessoa, CircuitoPago circuitoPago) {
        this.pessoa = pessoa;
        this.valor = circuitoPago.verificarValor(pessoa);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    @Override
    public String toString() {
        return "Domain.Inscricao{" +
                ", pessoa=" + pessoa +
                ", valor=" + valor +
                '}';
    }
}

package Domain;

import Domain.CircuitoPago;

public class Inscricao {
    private Integer ID;
    private Pessoa pessoa;
    private Double valor;

    public Inscricao(Integer ID, Pessoa pessoa, CircuitoPago circuitoPago) {
        this.ID = ID;
        this.pessoa = pessoa;
        this.valor = circuitoPago.verificarValor(pessoa);
    }

    public Integer getID() {
        return ID;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    @Override
    public String toString() {
        return "Inscricao{" +
                "ID=" + ID +
                ", pessoa=" + pessoa +
                ", valor=" + valor +
                '}';
    }
}

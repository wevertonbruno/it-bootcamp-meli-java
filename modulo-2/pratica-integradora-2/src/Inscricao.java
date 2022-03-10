public class Inscricao {
    private Circuito circuito;
    private Pessoa pessoa;

    public Inscricao(Pessoa pessoa, Circuito circuito) {
        this.pessoa = pessoa;
        this.circuito = circuito;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    @Override
    public String toString() {
        return "Inscricao{" +
                "circuito=" + circuito.getId() +
                ", pessoa=" + pessoa +
                ", valor=" + circuito.verificarValor(pessoa) +
                '}';
    }
}

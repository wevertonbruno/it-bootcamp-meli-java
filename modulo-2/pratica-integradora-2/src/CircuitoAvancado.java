public class CircuitoAvancado implements Circuito{
    @Override
    public Double verificarValor(Pessoa pessoa) {
        if(pessoa.getIdade() < 18){
            throw new PermissaoNegadaException("A inscricao nao eh permitida para menores de 18 anos.");
        }

        return 2800.00;
    }

    @Override
    public String getId() {
        return "circuito_avancado";
    }
}

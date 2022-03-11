package Domain;

import Domain.CircuitoPago;

public class CircuitoPequeno extends CircuitoBase implements CircuitoPago {
    @Override
    public Double verificarValor(Pessoa pessoa) {
        if(pessoa.getIdade() < 18){
            return 1300.00;
        }

        return 1500.00;
    }

    @Override
    public String getId() {
        return "circuito_pequeno";
    }
}

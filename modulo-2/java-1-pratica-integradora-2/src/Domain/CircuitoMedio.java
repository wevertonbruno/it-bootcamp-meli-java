package Domain;

import Domain.CircuitoPago;

public class CircuitoMedio extends CircuitoBase implements CircuitoPago {
    @Override
    public Double verificarValor(Pessoa pessoa) {
        if(pessoa.getIdade() < 18){
            return 2000.00;
        }

        return 2300.00;
    }

    @Override
    public String getId() {
        return "circuito_medio";
    }
}


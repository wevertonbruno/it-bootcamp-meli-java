package Domain;

import Domain.CircuitoPago;
import Exceptions.PermissaoNegadaException;

import java.util.ArrayList;
import java.util.List;

public class CircuitoAvancado extends CircuitoBase implements CircuitoPago {

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

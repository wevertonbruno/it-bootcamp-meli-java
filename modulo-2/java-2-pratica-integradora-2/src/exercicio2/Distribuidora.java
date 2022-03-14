package exercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<Produto>();

        produtos.addAll(Arrays.asList(
                new Perecivel("Arroz", 5.0, 2),
                new Perecivel("Feijao", 7.0, 5),
                new NaoPerecivel("Desinfetante", 15.0, "Limpeza"),
                new NaoPerecivel("Franela", 2.0, "Higiene")
        ));

        Double valor = 0.0;

        for(Produto produto : produtos){
            valor += produto.calcular(5);
        }

        System.out.println(String.format("Total a pagar: R$ %.2f", valor));
    }
}

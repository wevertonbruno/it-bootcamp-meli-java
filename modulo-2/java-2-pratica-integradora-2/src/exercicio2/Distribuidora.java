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

        Double total = 0.0;

        System.out.println("--------------------");
        for(Produto produto : produtos){
            Double subtotal = produto.calcular(5);
            total += subtotal;
            System.out.println(String.format("%d x %s \t%f\t%f", 5, produto.getNome(), produto.getPreco(), subtotal));
        }

        System.out.println(String.format("Total a pagar: R$ %.2f", total));
    }
}
